package com.example.member.controller;

import com.example.member.exception.PhoneExistException;
import com.example.member.exception.UsernameExistException;
import com.example.member.service.MemberService;
import com.example.member.vo.MemberRegistVo;
import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
