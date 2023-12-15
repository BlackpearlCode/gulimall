package com.gulimall.thirdparty.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.gulimall.thirdparty.service.GetAuthTokenService;
import com.gulimall.thirdparty.tools.AlipaySystemOauthToken;
import com.gulimall.thirdparty.vo.Oauth2UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GetAuthTokenServiceImpl implements GetAuthTokenService {

    @Autowired
    private AlipaySystemOauthToken alipayClient;
    @Override
    public Oauth2UserInfo getUserInfoByAccessToken(String code) throws AlipayApiException {
        AlipaySystemOauthTokenResponse response = alipayClient.getAuthToken(code);
        if(null==response){
            return null;
        }
        Oauth2UserInfo userInfo = new Oauth2UserInfo();
        //获取社交用户唯一标识id
        userInfo.setOpenId(response.getOpenId());
        //获取用户令牌（token）
        userInfo.setAccessToken(response.getAccessToken());
        //获取访问令牌的有效时间
        userInfo.setExpiresIn(Long.parseLong(response.getExpiresIn()));
        //更加令牌获取用户信息
        AlipayUserInfoShareResponse  userInfoShareResponse = alipayClient.getUserInfo(response.getAccessToken());
        userInfo.setNickname(userInfoShareResponse.getNickName());
        return userInfo;
    }

}
