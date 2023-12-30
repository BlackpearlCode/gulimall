package com.example.order.feign;

import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("gulimall-ware")
public interface WmsFeignService {
    @GetMapping("ware/waresku/hasStock")
    public Result getSkusHasStock(@RequestBody List<Long> skuIds);
}
