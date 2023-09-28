package com.gulimall.product.controller;

import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.utils.Result;
import com.gulimall.product.entity.PmsSkuInfo;
import com.gulimall.product.service.impl.PmsSkuInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("product/skuinfo")
public class SKuInfoContorller {

    @Autowired
    private PmsSkuInfoServiceImpl skuInfoService;


    /**
     * 根据条件查询sku列表信息
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String,Object> params){
        PageEntity pageEntity=skuInfoService.getSkuInfo(params);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg()).put("page",pageEntity);
    }


    @RequestMapping("/info/{skuId}")
    public Result info(@PathVariable("skuId") Long skuId){
        PmsSkuInfo skuInfo = skuInfoService.selectByPrimaryKey(skuId);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg()).put("sku",skuInfo);
    }
}
