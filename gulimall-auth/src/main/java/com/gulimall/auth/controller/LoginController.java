package com.gulimall.auth.controller;


import com.gulimall.auth.feign.RedisFeginService;
import com.gulimall.auth.feign.ThirdPartyFeginService;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.UUID;

import static com.gulimall.common.utils.BizCodeEnum.SMS_CODE_EXCEPTION;

@Controller
public class LoginController {

    @Autowired
    private ThirdPartyFeginService thirdPartyFeginService;

    @Autowired
    private RedisFeginService redisFeginService;

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
        String codeString = generateCode() + "_" + System.currentTimeMillis();
        String code="{'code':"+generateCode()+"}";
        //redis缓存验证码，防止同一个手机号在60秒内再次发送验证码
        redisFeginService.saveCode(phone,codeString,300);
        thirdPartyFeginService.sendCode(phone,code);

        return Result.ok();
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
