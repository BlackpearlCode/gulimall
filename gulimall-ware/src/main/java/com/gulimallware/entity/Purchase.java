package com.gulimallware.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 采购信息
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {
    private Long id;

    private Long assigneeId;

    private String assigneeName;

    private String phone;

    private Integer priority;

    private Integer status;

    private Long wareId;

    private BigDecimal amount;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}