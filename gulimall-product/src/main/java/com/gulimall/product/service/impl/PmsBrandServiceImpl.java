package com.gulimall.product.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.product.entity.PmsBrand;
import com.gulimall.product.mapper.PmsBrandMapper;
import com.gulimall.product.service.PmsBrandService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public int deleteByPrimaryKey(Long brandId) {
        return pmsBrandMapper.deleteByPrimaryKey(brandId);
    }

    @Override
    public int insert(PmsBrand record) {
        return pmsBrandMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBrand record) {
        return pmsBrandMapper.insertSelective(record);
    }

    @Override
    public PmsBrand selectByPrimaryKey(Long brandId) {
        return pmsBrandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBrand record) {
        return pmsBrandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBrand record) {
        return pmsBrandMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageEntity selectAll(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<PmsBrand> brandList=pmsBrandMapper.selectAll();
        PageInfo<PmsBrand> pageInfo=new PageInfo<>(brandList);
        PageEntity pageEntity=new PageEntity(pageInfo.getTotal(), pageInfo.getPages(),pageInfo.getList());

        return pageEntity;
    }

    @Override
    public int batchDelete(List<Long> brandIds) {
        return pmsBrandMapper.BatchDelete(brandIds);
    }

    @Override
    public PageEntity selectByName(int page, int limit,String name) {
        PageHelper.startPage(page,limit);
        List<PmsBrand> brandList=pmsBrandMapper.selectByName(name);
        PageInfo<PmsBrand> pageInfo=new PageInfo<>(brandList);
        PageEntity pageEntity=new PageEntity(pageInfo.getTotal(), pageInfo.getPages(),pageInfo.getList());

        return pageEntity;
    }

    @Override
    public List<PmsBrand> getBrands(List<Long> ids) {
        return pmsBrandMapper.getBrands(ids);
    }


}
