package com.gulimall.cart.feign;

import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("gulimall-product")
public interface ProductFeignService {
    @RequestMapping("/product/skuinfo/info/{skuId}")
    public Result info(@PathVariable("skuId") Long skuId);

    @GetMapping("/product/skuinfo/stringlist/{skuId}")
    public List<String> getSkuSaleAtttrValues(@PathVariable ("skuId") Long skuId);
}
