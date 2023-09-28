package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsProductAttrValue;
import com.gulimall.product.mapper.PmsProductAttrValueMapper;
import com.gulimall.product.service.PmsProductAttrValueService;
import com.gulimall.product.vo.BaseAttrs;
import com.gulimall.product.vo.ListForspuIdVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PmsProductAttrValueServiceImpl implements PmsProductAttrValueService {

    @Resource
    private PmsProductAttrValueMapper pmsProductAttrValueMapper;

    @Resource
    private PmsAttrServiceImpl attrService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsProductAttrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsProductAttrValue record) {
        return pmsProductAttrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsProductAttrValue record) {
        return pmsProductAttrValueMapper.insertSelective(record);
    }

    @Override
    public PmsProductAttrValue selectByPrimaryKey(Long id) {
        return pmsProductAttrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductAttrValue record) {
        return pmsProductAttrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductAttrValue record) {
        return pmsProductAttrValueMapper.updateByPrimaryKey(record);
    }

    @Override
    public void save(Long id,List<BaseAttrs> baseAttrs) {

        List<PmsProductAttrValue> productAttrValues = baseAttrs.stream().map(attr -> {
            PmsProductAttrValue productAttrValue = new PmsProductAttrValue();
            productAttrValue.setAttrId(attr.getAttrId());
            //根据attrid查询attrName
            productAttrValue.setAttrName(attrService.selectByPrimaryKey(attr.getAttrId()).getAttrName());
            productAttrValue.setAttrValue(attr.getAttrValues());
            productAttrValue.setSpuId(id);
            productAttrValue.setQuickShow((byte) attr.getShowDesc());
            return productAttrValue;
        }).collect(Collectors.toList());
        pmsProductAttrValueMapper.batchSave(productAttrValues);
    }

    @Override
    public List<PmsProductAttrValue> selectBySpuId(Long spuId) {

        return pmsProductAttrValueMapper.selectBySpuId(spuId);
    }

    @Override
    public void updateBySpuIds(List<ListForspuIdVo> vo) {
        pmsProductAttrValueMapper.updateBySpuIds(vo);
    }

}
