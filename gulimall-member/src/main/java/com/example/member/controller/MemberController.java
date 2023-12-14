package com.example.member.controller;

import com.example.member.entity.Member;
import com.example.member.exception.PhoneExistException;
import com.example.member.exception.UsernameExistException;
import com.example.member.service.MemberService;
import com.example.member.vo.MemberLoginVo;
import com.example.member.vo.MemberRegistVo;
import com.example.member.vo.Oauth2UserInfo;
import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RequestMapping("member/member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    //会员注册
    @RequestMapping("/regist")
    public Result regist(@RequestBody MemberRegistVo vo){
        try {
            memberService.regist(vo);
        }catch (PhoneExistException e){
            return Result.error(BizCodeEnum.PHONE_EXISTS_EXCEPTION);
        }catch (UsernameExistException e){
            return Result.error(BizCodeEnum.USER_EXISTS_EXCEPTION);
        }
        return Result.ok();
    }

    //会员登录
    @PostMapping("/login")
    public Result login(@RequestBody MemberLoginVo vo){
        Member member=memberService.login(vo);
        if(member!=null){
            return Result.ok();
        }
        return Result.error(BizCodeEnum.LOGINACCT_PASSWORD_EXCEPTION);
    }

    //第三方社交登录
    @RequestMapping("/oauth2/login")
    public Result oauth2Login(@RequestBody Oauth2UserInfo userInfo) throws ParseException {
        if(userInfo==null){
            return Result.error(BizCodeEnum.OAUTH2_LOGIN_EXCEPTION);
        }
        Member member=memberService.oauth2Login(userInfo);
        if(member!=null){
            return Result.ok();
        }
        return Result.error(BizCodeEnum.OAUTH2_LOGIN_EXCEPTION);
    }
}
