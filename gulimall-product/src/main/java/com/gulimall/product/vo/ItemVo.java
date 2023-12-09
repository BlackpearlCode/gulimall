package com.gulimall.product.vo;

import com.gulimall.product.entity.PmsSkuImages;
import com.gulimall.product.entity.PmsSkuInfo;
import com.gulimall.product.entity.PmsSpuInfoDesc;
import lombok.Data;

import java.util.List;
@Data
public class ItemVo {

    //sku基本信息
    private PmsSkuInfo info;
    //sku图片信息
    private List<PmsSkuImages> images;
    //获取spu的销售属性组合
    private List<SkuItemSaleAttrVo> saleAttr;
    //获取spu的介绍
    private PmsSpuInfoDesc desc;
    //获取spu的规格参数信息
    private List<SpuItemAttrGroupVo>   groupAttrs;

}
