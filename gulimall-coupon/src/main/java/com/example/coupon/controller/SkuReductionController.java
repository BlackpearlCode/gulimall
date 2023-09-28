package com.example.coupon.controller;

import com.example.coupon.service.serviceImpl.SkuFullReductionServiceImpl;
import com.gulimall.common.to.SkuReductionTo;
import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuReductionController {

    @Autowired
    private SkuFullReductionServiceImpl fullReductionService;

    /**
     * 满减
     * @param skuReductionTo
     * @return
     */
    @RequestMapping("/saveInfo")
    public Result saveInfo(@RequestBody SkuReductionTo skuReductionTo){
        fullReductionService.save(skuReductionTo);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
    }
}
