package com.gulimallware.controller;

import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.utils.Result;
import com.gulimallware.service.serviceImpl.WareSkuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("ware/waresku")
@RestController
public class WareSkuController {

    @Autowired
    private WareSkuServiceImpl wareSkuService;

    @RequestMapping("/list")
    public Result list(@RequestParam Map<String,Object> params){
        PageEntity pageEntity=wareSkuService.getAll(params);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg()).put("page",pageEntity);
    }
}
