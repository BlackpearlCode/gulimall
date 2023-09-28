package com.example.member.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 会员登录记录
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginLog implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * member_id
    */
    private Long memberId;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * ip
    */
    private String ip;

    /**
    * city
    */
    private String city;

    /**
    * 登录类型[1-web，2-app]
    */
    private Boolean loginType;

    private static final long serialVersionUID = 1L;
}