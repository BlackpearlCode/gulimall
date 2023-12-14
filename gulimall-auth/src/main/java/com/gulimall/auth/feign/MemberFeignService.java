package com.gulimall.auth.feign;

import com.gulimall.auth.vo.Oauth2UserInfo;
import com.gulimall.auth.vo.UserLoginVo;
import com.gulimall.auth.vo.UserRegistVo;
import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@FeignClient(name = "gulimall-member")
public interface MemberFeignService {

    @RequestMapping("/member/member/regist")
    Result regist(@RequestBody UserRegistVo vo);

    @PostMapping("/member/member/login")
    Result login(@RequestBody UserLoginVo vo);

    @RequestMapping("/member/member/oauth2/login")
    Result oauth2Login(@RequestBody Oauth2UserInfo userInfo) throws ParseException;
}
