package com.es.feign;

import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-product")
public interface ProductFeign {
    @RequestMapping("product/attr/info/{attrId}")
    Result info(@PathVariable("attrId") Long attrId);
}
