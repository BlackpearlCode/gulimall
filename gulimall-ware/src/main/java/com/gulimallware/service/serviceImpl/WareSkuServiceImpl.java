package com.gulimallware.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.to.SkusHasStockVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.mapper.WareSkuMapper;
import com.gulimallware.entity.WareSku;
import com.gulimallware.service.WareSkuService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WareSkuServiceImpl implements WareSkuService{

    @Resource
    private WareSkuMapper wareSkuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return wareSkuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WareSku record) {
        return wareSkuMapper.insert(record);
    }

    @Override
    public int insertSelective(WareSku record) {
        return wareSkuMapper.insertSelective(record);
    }

    @Override
    public WareSku selectByPrimaryKey(Long id) {
        return wareSkuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WareSku record) {
        return wareSkuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WareSku record) {
        return wareSkuMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageEntity getAll(Map<String, Object> params) {

        List<WareSku> wareSkuList=wareSkuMapper.getAll(params);
        PageHelper.startPage(Integer.parseInt((String) params.get("page")),Integer.parseInt((String) params.get("limit")));
        PageInfo<WareSku> pageInfo=new PageInfo<>(wareSkuList);
        PageEntity pageEntity=new PageEntity(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        return pageEntity;
    }

    @Override
    public List<SkusHasStockVo> getSkusHasStock(List<Long> skuIds) {
        List<SkusHasStockVo> stockVos = skuIds.stream().map(skuId -> {
            SkusHasStockVo vo = new SkusHasStockVo();
            int count = wareSkuMapper.selectBySkuId(skuId);
            Boolean bool=count >0 ?true:false;
            vo.setSkuId(skuId);
            vo.setHasStock(bool);
            return vo;
        }).collect(Collectors.toList());
        return stockVos;
    }

}
