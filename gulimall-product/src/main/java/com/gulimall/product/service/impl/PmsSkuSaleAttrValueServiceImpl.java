package com.gulimall.product.service.impl;
import com.gulimall.product.entity.PmsSkuSaleAttrValue;
import com.gulimall.product.mapper.PmsAttrAttrgroupRelationMapper;
import com.gulimall.product.mapper.PmsAttrGroupMapper;
import com.gulimall.product.mapper.PmsAttrMapper;
import com.gulimall.product.mapper.PmsSkuSaleAttrValueMapper;
import com.gulimall.product.service.PmsSkuSaleAttrValueService;
import com.gulimall.product.vo.SkuItemSaleAttrVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId) {
        List<SkuItemSaleAttrVo> saleAttrVos=pmsSkuSaleAttrValueMapper.getSaleAttrsBySpuId(spuId);
        return saleAttrVos;
    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId) {
       return pmsSkuSaleAttrValueMapper.getSkuSaleAttrValuesAsStringList(skuId);
    }

}
