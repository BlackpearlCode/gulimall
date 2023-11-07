package com.gulimall.common.utils;



import java.util.HashMap;



public class Result<T> extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static Result r(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

}
