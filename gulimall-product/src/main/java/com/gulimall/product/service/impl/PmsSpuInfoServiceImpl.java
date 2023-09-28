package com.gulimall.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulimall.common.to.SpuBoundTo;
import com.gulimall.common.utils.PageEntity;
import com.gulimall.common.constant.PublishStatusConstrant;
import com.gulimall.product.entity.PmsSpuInfo;
import com.gulimall.product.entity.PmsSpuInfoDesc;
import com.gulimall.product.feign.CouponFeignService;
import com.gulimall.product.mapper.PmsSpuInfoMapper;
import com.gulimall.product.service.PmsSpuInfoService;
import com.gulimall.product.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PmsSpuInfoServiceImpl implements PmsSpuInfoService {

    @Resource
    private PmsSpuInfoMapper pmsSpuInfoMapper;

    @Resource
    private PmsSpuInfoDescServiceImpl pmsSpuInfoDescService;

    @Resource
    private PmsSpuImagesServiceImpl pmsSpuImagesService;

    @Resource
    private PmsProductAttrValueServiceImpl productAttrValueService;

    @Autowired
    private CouponFeignService couponFeignService;

    @Resource
    private PmsSkuInfoServiceImpl pmsSkuInfoService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSpuInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSpuInfo record) {
        return pmsSpuInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSpuInfo record) {
        return pmsSpuInfoMapper.insertSelective(record);
    }

    @Override
    public PmsSpuInfo selectByPrimaryKey(Long id) {
        return pmsSpuInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSpuInfo record) {
        return pmsSpuInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSpuInfo record) {
        return pmsSpuInfoMapper.updateByPrimaryKey(record);
    }

    @Transactional
    @Override
    public void saveSpuInfo(SpuInFo spu) {
        //1.保存spu基本信息 pms_spu_info
        PmsSpuInfo spuInfo=new PmsSpuInfo();
        BeanUtils.copyProperties(spu,spuInfo);
        spuInfo.setCreateTime(new Date());
        spuInfo.setUpdateTime(new Date());
        spuInfo.setPublishStatus((byte) PublishStatusConstrant.NEWbUILE.getCode());
        pmsSpuInfoMapper.insert(spuInfo);
        //2.保存spu的描述图片 pms_spu_info_desc
        PmsSpuInfoDesc spuInfoDesc=new PmsSpuInfoDesc();
        spuInfoDesc.setSpuId(spuInfo.getId());
        spuInfoDesc.setDecript(String.join(",",spu.getDecript()));
        pmsSpuInfoDescService.insert(spuInfoDesc);
        //3.保存spu的图片集 pms_spu_images
        List<String> images = spu.getImages();
        Long id=spuInfo.getId();
        pmsSpuImagesService.batchSave(id,images);
        //4.保存spu的规格参数 pms_product_attr_value
        List<BaseAttrs> baseAttrs = spu.getBaseAttrs();
        productAttrValueService.save(id,baseAttrs);
        //5.保存spu的积分信息 gulimall_sms->sms_spu_bounds
        Bounds bounds = spu.getBounds();
        SpuBoundTo boundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds,boundTo);
        boundTo.setSpuId(id);
        couponFeignService.saveSpuBounds(boundTo);
        //6保存当前spu对应的sku信息
        List<Skus> skus = spu.getSkus();
        pmsSkuInfoService.save(id,skus,spuInfo);

    }

    @Override
    public PageEntity getAll(Map<String, Object> params) {

        List<PmsSpuInfo> list=pmsSpuInfoMapper.getAll(params);
        PageHelper.startPage( Integer.parseInt((String) params.get("page")),Integer.parseInt((String) params.get("limit")));
        PageInfo<PmsSpuInfo> spuInFoPageInfo = new PageInfo<>(list);
        PageEntity pageEntity=new PageEntity(spuInFoPageInfo.getTotal(),spuInFoPageInfo.getPages(),spuInFoPageInfo.getList());
        return pageEntity;
    }

}
