package com.gulimall.thirdparty.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface OssServerService {
     //服务端签名直传
     Map<String,String> doGet(HttpServletRequest request, HttpServletResponse response);

     //批量删除文件
     void batchDelete(List<String> filePaths);




}
