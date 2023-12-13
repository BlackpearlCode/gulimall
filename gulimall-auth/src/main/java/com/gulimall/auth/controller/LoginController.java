package com.gulimall.auth.controller;


import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.gulimall.auth.feign.MemberFeignService;
import com.gulimall.auth.feign.RedisFeginService;
import com.gulimall.auth.feign.ThirdPartyFeginService;
import com.gulimall.auth.vo.UserLoginVo;
import com.gulimall.auth.vo.UserRegistVo;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.gulimall.common.utils.BizCodeEnum.SMS_CODE_EXCEPTION;

@Controller
public class LoginController {

    @Autowired
    private ThirdPartyFeginService thirdPartyFeginService;

    @Autowired
    private RedisFeginService redisFeginService;

    @Autowired
    private MemberFeignService memberFeignService;

    /**
     * 发送验证码
     * @param phone：手机号
     * @return
     * @throws Exception
     */
    @GetMapping("/sms/sendCode")
    @ResponseBody
    public Result sendCode(@RequestParam("phone") String phone) throws Exception {
        //TODO 1.接口防刷
        String redisCode = redisFeginService.getCode(phone);
        if(!StringUtils.isEmpty(redisCode)){
            Long l=Long.parseLong(redisCode.split("_")[1]);
            //判断手机号60秒内是否发送过验证码
            if(System.currentTimeMillis()-l<60000){
                return Result.r(SMS_CODE_EXCEPTION.getCode(),SMS_CODE_EXCEPTION.getMsg());
            }
        }

        //2.验证码再次校验 key=手机号，value=code
        //生成验证码
        String uuid = generateCode();
        String codeString = uuid + "_" + System.currentTimeMillis();
        String code="{'code':"+uuid+"}";
        //redis缓存验证码，防止同一个手机号在60秒内再次发送验证码
        redisFeginService.saveCode(phone,codeString,300);
        thirdPartyFeginService.sendCode(phone,code);
        return Result.ok();
    }

    /**
     * RedirectAttributes:模拟重定向携带数据
     * @param vo
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://auth.onlineshopping.com/reg.html";
        }
        //获取验证码
        String code=vo.getCode().split("_")[0];
        String key=vo.getPhone();
        String redisCode = redisFeginService.getCode(key).split("_")[0];
        //校验验证码
        if(!redisCode.equals(code)){
            HashMap<String, String> errors = new HashMap<>();
            errors.put("code","验证码错误");
            redirectAttributes.addFlashAttribute("errors",errors);
            return "redirect:http://auth.onlineshopping.com/reg.html";
        }
        //验证码校验通过删除验证码缓存
        redisFeginService.delCode(key);
        //注册
        Result r = memberFeignService.regist(vo);
        if(r.getCode()==0){
            //成功
            return "redirect:http://auth.onlineshopping.com/login.html";
        };
        //注册失败，返回登录页
        HashMap<String, String> errors = new HashMap<>();
        errors.put("msg", (String) r.get("data"));
        redirectAttributes.addFlashAttribute("errors",errors);
        return "redirect:http://auth.onlineshopping.com/reg.html";
    }

    @PostMapping("/login")
    public String login(UserLoginVo vo,RedirectAttributes redirectAttributes){
        //远程登录
        Result r = memberFeignService.login(vo);
        if(r.getCode()==0){
            return "redirect:http://onlineshopping.com";
        }
        HashMap<String, String> errors = new HashMap<>();
        Gson gson=new Gson();
        String data = gson.toJson(r.get("msg"));
        errors.put("msg", data);
        redirectAttributes.addFlashAttribute("errors",errors);
        return "redirect:http://auth.onlineshopping.com/login.html";
    }




    /**
     * 生成六位数随机验证码
     * @return
     */
    public  String generateCode() {
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = (int)(Math.random() * chars.length());
            sb.append(chars.charAt(number));
        }
        return sb.toString();
    }

}
