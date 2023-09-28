package com.gulimallware.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimallware.entity.Purchase;
import com.gulimallware.vo.MergeVo;
import com.gulimallware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

public interface PurchaseService{


    int deleteByPrimaryKey(Long id);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    PageEntity getAll(Map<String, Object> params);

    List<Purchase> getUnreceiveList();

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);

    void batchDel(List<Long> ids);
}
