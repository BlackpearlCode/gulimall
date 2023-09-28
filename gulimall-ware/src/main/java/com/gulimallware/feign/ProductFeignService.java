package com.gulimallware.feign;

import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-product")
public interface ProductFeignService {

    //通过skuId远程获取sku信息
    @RequestMapping("/product/skuinfo/info/{skuId}")
    Result info(@PathVariable("skuId") Long skuId);
}
