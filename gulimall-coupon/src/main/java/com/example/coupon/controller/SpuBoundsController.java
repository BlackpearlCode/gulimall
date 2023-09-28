package com.example.coupon.controller;


import com.example.coupon.entity.SpuBounds;
import com.example.coupon.service.serviceImpl.SpuBoundsServiceImpl;
import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("coupon/spubounds")
@RestController
public class SpuBoundsController {

    @Autowired
    private SpuBoundsServiceImpl spuBoundsService;

    @RequestMapping("/save")
    public Result save(@RequestBody SpuBounds SpuBounds){
        spuBoundsService.insert(SpuBounds);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
    }
}
