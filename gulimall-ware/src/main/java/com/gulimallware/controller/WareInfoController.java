package com.gulimallware.controller;

import com.gulimall.common.utils.BizCodeEnum;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.utils.Result;
import com.gulimallware.entity.WareInfo;
import com.gulimallware.service.serviceImpl.WareInfoServiceImpl;
import com.gulimallware.vo.FareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequestMapping("ware/wareinfo")
@RestController
public class WareInfoController {

    @Autowired
    private WareInfoServiceImpl wareInfoService;

    /**
     * 根据条件查询
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String,Object> params){
        PageEntity pageEntity =wareInfoService.getAll(params);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg()).put("page",pageEntity);
    }

    /**
     * 更加id查询对应的仓库信息
     */
    @RequestMapping("/info/{id}")
    public Result wareInfo(@PathVariable("id") Long id){
        WareInfo wareInfo = wareInfoService.selectByPrimaryKey(id);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg()).put("wareInfo",wareInfo);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody WareInfo ware){
        wareInfoService.updateByPrimaryKeySelective(ware);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
    }

    /**
     * 根据id删除仓库
     */
    @RequestMapping("/delete")
    public Result deleteById(@RequestParam List<Long> ids){
        wareInfoService.batchDeleteById(ids);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
    }

    @RequestMapping("/save")
    public Result save(@RequestBody WareInfo ware){
        wareInfoService.insertSelective(ware);
        return Result.r(BizCodeEnum.OK.getCode(), BizCodeEnum.OK.getMsg());
    }

    /**
     * 获取运费信息
     * @param id
     * @return
     */
    @GetMapping("/fare")
    public Result fare(@RequestParam("addrId") Long id){
        FareVo fare=wareInfoService.getFare(id);
        return Result.ok().setData(fare);
    }
}
