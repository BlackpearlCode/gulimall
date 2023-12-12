package com.gulimall.common.utils;


public enum BizCodeEnum {

    SMS_CODE_EXCEPTION(10002,"验证码获取频率太高，请稍后再试"),

    VAILD_EXCEPTION(10001,"参数校验失败"),
    UNKNOW_EXCEPION(10000,"系统未知异常"),

    OK(0,"SUCCESS"),
    ERROR(500,"ERROR"),
    PRODUCT_UP_EXCEPTION(11000,"商品上架异常");


    private int code;
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
