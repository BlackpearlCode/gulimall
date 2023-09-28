package com.gulimall.product.feign;

import com.gulimall.common.to.SkuReductionTo;
import com.gulimall.common.to.SpuBoundTo;
import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/skufullreduction/saveInfo")
    Result saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);

    @RequestMapping("/coupon/spubounds/save")
    Result saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);
}
