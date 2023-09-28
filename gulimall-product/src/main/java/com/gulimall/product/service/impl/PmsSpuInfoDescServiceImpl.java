package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsSpuInfoDesc;
import com.gulimall.product.mapper.PmsSpuInfoDescMapper;
import com.gulimall.product.service.PmsSpuInfoDescService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PmsSpuInfoDescServiceImpl implements PmsSpuInfoDescService {

    @Resource
    private PmsSpuInfoDescMapper pmsSpuInfoDescMapper;

    @Override
    public int deleteByPrimaryKey(Long spuId) {
        return pmsSpuInfoDescMapper.deleteByPrimaryKey(spuId);
    }

    @Override
    public int insert(PmsSpuInfoDesc record) {
        return pmsSpuInfoDescMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSpuInfoDesc record) {
        return pmsSpuInfoDescMapper.insertSelective(record);
    }

    @Override
    public PmsSpuInfoDesc selectByPrimaryKey(Long spuId) {
        return pmsSpuInfoDescMapper.selectByPrimaryKey(spuId);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSpuInfoDesc record) {
        return pmsSpuInfoDescMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSpuInfoDesc record) {
        return pmsSpuInfoDescMapper.updateByPrimaryKey(record);
    }

}
