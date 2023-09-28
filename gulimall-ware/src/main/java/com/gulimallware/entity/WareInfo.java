package com.gulimallware.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 仓库信息
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareInfo implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 仓库名
    */
    private String name;

    /**
    * 仓库地址
    */
    private String address;

    /**
    * 区域编码
    */
    private String areacode;

    private static final long serialVersionUID = 1L;
}