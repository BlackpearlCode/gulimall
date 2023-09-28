package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsCategoryBrandRelation;
import com.gulimall.product.mapper.PmsCategoryBrandRelationMapper;
import com.gulimall.product.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsCategoryBrandRelationServiceImpl implements PmsCategoryBrandRelationService {

    @Resource
    private PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsCategoryBrandRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsCategoryBrandRelation record) {
        return pmsCategoryBrandRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsCategoryBrandRelation record) {
        return pmsCategoryBrandRelationMapper.insertSelective(record);
    }

    @Override
    public PmsCategoryBrandRelation selectByPrimaryKey(Long id) {
        return pmsCategoryBrandRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsCategoryBrandRelation record) {
        return pmsCategoryBrandRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsCategoryBrandRelation record) {
        return pmsCategoryBrandRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsCategoryBrandRelation> selectByBrandId(Long brandId) {
        return pmsCategoryBrandRelationMapper.selectByBradnId(brandId);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return pmsCategoryBrandRelationMapper.batchDelete(ids);
    }

    @Override
    public int updateByBrandId(Long brandId, String brandName) {
        return pmsCategoryBrandRelationMapper.updateByBrandId(brandId,brandName);
    }

    @Override
    public int updateByCatelogId(Long catelogId, String catelogName) {
        return pmsCategoryBrandRelationMapper.updateByCatelogId(catelogId,catelogName);
    }

    @Override
    public int deleteByCatelogId(List<Long> catelogIds) {
        return pmsCategoryBrandRelationMapper.deleteByCatelogIds(catelogIds);
    }

    @Override
    public int deleteByBrandId(List<Long> brandIds) {
        return pmsCategoryBrandRelationMapper.deleteByBrands(brandIds);
    }

    @Override
    public List<PmsCategoryBrandRelation> getBrandsByCatelogId(Long catId) {
        return pmsCategoryBrandRelationMapper.getBrandsByCatelogId(catId);
    }

}
