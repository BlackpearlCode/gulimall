package com.gulimall.product.controller;

import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.utils.Result;
import com.gulimall.product.entity.PmsSpuInfo;
import com.gulimall.product.service.impl.PmsSpuInfoServiceImpl;
import com.gulimall.product.vo.SpuInFo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("product/spuinfo")
@RestController
public class SpuInfoController {

    @Autowired
    private PmsSpuInfoServiceImpl spuInfoService;

    @RequestMapping("/save")
    public Result save(@RequestBody SpuInFo spu){
        spuInfoService.saveSpuInfo(spu);
        return Result.r(BizCodeEnum.OK.getCode(),BizCodeEnum.OK.getMsg());
    }


    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageEntity pageEntity = spuInfoService.getAll(params);
        return Result.r(BizCodeEnum.OK.getCode(),BizCodeEnum.OK.getMsg()).put("page",pageEntity);
    }

    //商品上架
//    @RequestMapping("/{id}/up")
//    public Result update(@PathVariable("id")Long id){
//        PmsSpuInfo spuInfo = spuInfoService.selectByPrimaryKey(id);
//        //设置商品为上架状态
//        spuInfo.setPublishStatus((byte) 1);
//        spuInfoService.updateByPrimaryKeySelective(spuInfo);
//        return Result.r(BizCodeEnum.OK.getCode(),BizCodeEnum.OK.getMsg());
//    }
    @RequestMapping("/{id}/up")
    public Result update(@PathVariable("id")Long id){
        spuInfoService.up(id);
        return Result.r(BizCodeEnum.OK.getCode(),BizCodeEnum.OK.getMsg());
    }

    /**
     * 根据skuId获取spu信息
     * @param id
     * @return
     */
    @GetMapping("/skuId/{id}")
    public Result getSpuInfoBySkuId(@PathVariable("id") Long id){
        PmsSpuInfo spuInfo =spuInfoService.getSpuInfoBySkuId(id);
        return Result.r(BizCodeEnum.OK.getCode(),BizCodeEnum.OK.getMsg()).setData(spuInfo);
    }
}
