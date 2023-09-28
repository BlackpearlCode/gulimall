package com.gulimall.common.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ProductConstant {
    //base:基本属性
    ATTR_TYPE_BASE(1,"base"),
    //sale：销售属性
    ATTR_TYPE_SALE(0,"sale");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
