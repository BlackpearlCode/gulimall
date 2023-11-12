package com.gulimall.product.feign;



import com.gulimall.common.utils.Result;
import com.gulimall.product.vo.SkusHasStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("gulimall-ware")
public interface WareFeignService {

    @RequestMapping("ware/waresku/hasStock")
    List<SkusHasStockVo> getSkusHasStock(@RequestBody List<Long> skuIds);
}
