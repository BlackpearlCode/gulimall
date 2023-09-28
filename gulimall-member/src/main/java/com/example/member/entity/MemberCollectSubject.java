package com.example.member.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 会员收藏的专题活动
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCollectSubject implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * subject_id
    */
    private Long subjectId;

    /**
    * subject_name
    */
    private String subjectName;

    /**
    * subject_img
    */
    private String subjectImg;

    /**
    * 活动url
    */
    private String subjectUrll;

    private static final long serialVersionUID = 1L;
}