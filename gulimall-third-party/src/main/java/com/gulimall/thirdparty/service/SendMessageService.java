package com.gulimall.thirdparty.service;

import com.gulimall.common.utils.Result;

public interface SendMessageService {
    //发送验证码
    Result sendCode(String phone, String code) throws Exception;
}
