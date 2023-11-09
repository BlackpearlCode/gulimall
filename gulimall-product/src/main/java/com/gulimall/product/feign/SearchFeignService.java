package com.gulimall.product.feign;

import com.gulimall.common.es.SkuEsModel;
import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("gulimall-elasticsearch")
public interface SearchFeignService {

    @RequestMapping("/search/save/product")
    public Result productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
