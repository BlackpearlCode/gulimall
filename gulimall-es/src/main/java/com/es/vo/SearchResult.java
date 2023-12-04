package com.es.vo;

import com.gulimall.common.es.SkuEsModel;
import lombok.Data;

import java.util.List;

@Data
public class SearchResult {
    //查询到的所有商品信息
    private List<SkuEsModel> products;
    private Integer pageNum;//当前页
    private Long total;//总记录数
    private Integer totalPages;//总页码
    private List<BrandVo> brands;//当前查询到的结果，所有涉及到的品牌
    private List<AttrVo> attrs;//当前查询到的结果，所有涉及到的属性
    private List<CatalogVo> catalogs;//当前查询到的结果，所有涉及到的分类
    //==============以上是返回给页面的所有信息=========================
    @Data
    public static class BrandVo{
        //品牌id
        private Long brandId;
        //商品品牌名
        private String brandName;
        //商品品牌logo
        private String brandImg;
    }

    @Data
    public static class AttrVo{
        //属性id
        private Long attrId;
        //属性名
        private String name;
        //属性值
        private List<String> attrValue;
    }

    @Data
    public static class CatalogVo{
        //商品分类Id
        private Long catalogId;
        //商品分类名称
        private String catalogName;
    }
}
