package com.gulimall.common.utils;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;


public class Result<T> extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;


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

    public Result setData(Object data){
        put("data",data);
        return this;
    }

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result ok() {
        return new Result();
    }

    public Integer getCode() {

        return (Integer) this.get("code");
    }


    //利用fastjson进行反序列化
    public <T> T getData(String key, TypeReference<T> typeReference) {
        Object data = get(key);	//默认是map
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }



}
