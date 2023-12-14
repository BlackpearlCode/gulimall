package com.example.member.service;

import com.example.member.entity.Member;
import com.example.member.exception.PhoneExistException;
import com.example.member.exception.UsernameExistException;
import com.example.member.vo.MemberLoginVo;
import com.example.member.vo.MemberRegistVo;
import com.example.member.vo.Oauth2UserInfo;

import java.text.ParseException;

public interface MemberService{


    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    void regist(MemberRegistVo vo);
    //校验手机号是否唯一
    void checkPhoneUnique(String phone) throws PhoneExistException;
    //校验用户名是否唯一
    void checkUsernameUnique(String username) throws UsernameExistException;

    Member login(MemberLoginVo vo);

    Member oauth2Login(Oauth2UserInfo userInfo) throws ParseException;
}
