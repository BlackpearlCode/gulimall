package com.gulimall.product.service.impl;
import com.gulimall.product.entity.PmsSkuSaleAttrValue;
import com.gulimall.product.mapper.PmsAttrAttrgroupRelationMapper;
import com.gulimall.product.mapper.PmsAttrGroupMapper;
import com.gulimall.product.mapper.PmsAttrMapper;
import com.gulimall.product.mapper.PmsSkuSaleAttrValueMapper;
import com.gulimall.product.service.PmsSkuSaleAttrValueService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PmsSkuSaleAttrValueServiceImpl implements PmsSkuSaleAttrValueService {

    @Resource
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Resource
    private PmsAttrGroupMapper pmsAttrGroupMapper;
    @Resource
    private PmsAttrAttrgroupRelationMapper attrAttrgroupRelationMapper;
    @Resource
    private PmsAttrMapper attrMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuSaleAttrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSkuSaleAttrValue record) {
        return pmsSkuSaleAttrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSkuSaleAttrValue record) {
        return pmsSkuSaleAttrValueMapper.insertSelective(record);
    }

    @Override
    public PmsSkuSaleAttrValue selectByPrimaryKey(Long id) {
        return pmsSkuSaleAttrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuSaleAttrValue record) {
        return pmsSkuSaleAttrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuSaleAttrValue record) {
        return pmsSkuSaleAttrValueMapper.updateByPrimaryKey(record);
    }

}
