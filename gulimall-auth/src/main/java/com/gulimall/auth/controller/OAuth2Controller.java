package com.gulimall.auth.controller;

import com.alipay.api.AlipayApiException;
import com.gulimall.auth.feign.MemberFeignService;
import com.gulimall.auth.feign.ThirdPartyFeginService;
import com.gulimall.auth.vo.Oauth2UserInfo;
import com.gulimall.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

/**
 * 处理社交登录请求
 */
@Controller
@Slf4j
public class OAuth2Controller {

    @Autowired
    private ThirdPartyFeginService thirdPartyFeginService;
    @Autowired
    private MemberFeignService memberFeignService;

    @RequestMapping("/oauth2.0/zhifubao/success")
    public String zhifubao(@RequestParam("auth_code") String auth_code) throws AlipayApiException, ParseException {
        Oauth2UserInfo oauth2UserInfo = thirdPartyFeginService.oauth2Login(auth_code);
        if(oauth2UserInfo==null){
            log.error("获取用户信息失败");
            return "redirect:http://auth.onlineshopping.com/login.html";
        }

        Result result = memberFeignService.oauth2Login(oauth2UserInfo);
        if(result.getCode()==0){
            return "redirect:http://onlineshopping.com";
        }else{
            return "redirect:http://auth.onlineshopping.com/login.html";
        }

    }
}
