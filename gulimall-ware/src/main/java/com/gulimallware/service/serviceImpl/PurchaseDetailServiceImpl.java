package com.gulimallware.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulimall.common.utils.PageEntity;
import com.gulimallware.entity.WareSku;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.mapper.PurchaseDetailMapper;
import com.gulimallware.entity.PurchaseDetail;
import com.gulimallware.service.PurchaseDetailService;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{

    @Resource
    private PurchaseDetailMapper purchaseDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return purchaseDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PurchaseDetail record) {
        return purchaseDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(PurchaseDetail record) {
        return purchaseDetailMapper.insertSelective(record);
    }

    @Override
    public PurchaseDetail selectByPrimaryKey(Long id) {
        return purchaseDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PurchaseDetail record) {
        return purchaseDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PurchaseDetail record) {
        return purchaseDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageEntity getAll(Map<String, Object> params) {

        List<PurchaseDetail> purchaseDetailList=purchaseDetailMapper.getAll(params);
        PageHelper.startPage(Integer.parseInt((String) params.get("page")),Integer.parseInt((String) params.get("limit")));
        PageInfo<PurchaseDetail> pageInfo=new PageInfo<>(purchaseDetailList);
        PageEntity pageEntity=new PageEntity(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        return pageEntity;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        purchaseDetailMapper.batchDelete(ids);
    }

}
