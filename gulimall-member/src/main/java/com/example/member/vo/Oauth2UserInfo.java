package com.example.member.vo;

import lombok.Data;

@Data
public class Oauth2UserInfo {
    //获取社交用户唯一标识id
    private String userId;
    //获取用户令牌（token）
    private String accessToken ;
    //获取访问令牌的有效时间
    private long expiresIn ;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //用户名
    private String username;
    //性别
    private String gender;
    //所在城市
    private String city;
    //生日
    private String birthday;
}
