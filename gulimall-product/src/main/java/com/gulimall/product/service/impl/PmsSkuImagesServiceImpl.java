package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsSkuImages;
import com.gulimall.product.mapper.PmsSkuImagesMapper;
import com.gulimall.product.service.PmsSkuImagesService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PmsSkuImagesServiceImpl implements PmsSkuImagesService {

    @Resource
    private PmsSkuImagesMapper pmsSkuImagesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuImagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSkuImages record) {
        return pmsSkuImagesMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSkuImages record) {
        return pmsSkuImagesMapper.insertSelective(record);
    }

    @Override
    public PmsSkuImages selectByPrimaryKey(Long id) {
        return pmsSkuImagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuImages record) {
        return pmsSkuImagesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuImages record) {
        return pmsSkuImagesMapper.updateByPrimaryKey(record);
    }

}
