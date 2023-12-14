package com.gulimall.thirdparty.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.gulimall.thirdparty.vo.Oauth2UserInfo;

public interface GetAuthTokenService {

    //通过code获取token，在通过token获取用户信息
    Oauth2UserInfo getUserInfoByAccessToken(String code) throws AlipayApiException;


}
