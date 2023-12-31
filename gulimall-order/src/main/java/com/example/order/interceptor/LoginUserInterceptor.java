package com.example.order.interceptor;


import com.google.gson.Gson;
import com.gulimall.common.vo.TokenInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginUserInterceptor implements HandlerInterceptor {


    public static ThreadLocal<TokenInfo> loginUser=new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("loginUser");
        if(obj==null){
            //没登陆就去登录
            request.getSession().setAttribute("msg","请先登录");
            response.sendRedirect("http://auth.onlineshopping.com/login.html");
            return false;
        }
        Gson gson = new Gson();
        TokenInfo tokenInfo = gson.fromJson(gson.toJson(obj),TokenInfo.class);
        loginUser.set(tokenInfo);
        return true;
    }
}
