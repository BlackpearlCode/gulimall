package com.gulimall.common.utils;


public enum BizCodeEnum {

    VAILD_EXCEPTION(10001,"参数校验失败"),
    UNKNOW_EXCEPION(10000,"系统未知异常"),

    OK(0,"SUCCESS"),
    ERROR(500,"ERROR");

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
