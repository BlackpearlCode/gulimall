package com.es.controller;

import com.es.service.IEsService;
import com.gulimall.common.es.SkuEsModel;
import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping("/search")
@RestController
@Slf4j
public class ElasticSaveController {



    @Autowired
    private IEsService esService;

    //商品上架
    @RequestMapping("/save/product")
    public Result productStatusUp(@RequestBody List<SkuEsModel> skuEsModels)  {
        boolean b = false;
        try {
            b = esService.batchCreateDocument(skuEsModels);
        } catch (IOException e) {
            log.error("ElasticSaveController商品上架异常：{}",e);
            return Result.r(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMsg());
        }
        if(b){
            return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
        }else {
            return Result.r(BizCodeEnum.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMsg());
        }

    }
}
