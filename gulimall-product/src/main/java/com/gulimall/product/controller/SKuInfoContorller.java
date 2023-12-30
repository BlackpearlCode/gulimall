package com.gulimall.product.controller;

import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.utils.Result;
import com.gulimall.product.entity.PmsSkuInfo;
import com.gulimall.product.service.impl.PmsSkuInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product/skuinfo")
public class SKuInfoContorller {

    @Autowired
    private PmsSkuInfoServiceImpl skuInfoService;

    /**
     * 根据skuId查询销售属性
     * @param skuId
     * @return
     */
    @GetMapping("/stringlist/{skuId}")
    public List<String> getSkuSaleAtttrValues(@PathVariable ("skuId") Long skuId){
        return skuInfoService.getSkuSaleAtttrValues(skuId);
    }


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

    //获取商品价格
    @RequestMapping("/{skuId}/price")
    public BigDecimal getPrice(@PathVariable("skuId") Long skuId){
        return skuInfoService.selectByPrimaryKey(skuId).getPrice();
    }
}
