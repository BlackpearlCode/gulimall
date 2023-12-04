package com.es.service.serviceImpl;



import com.es.constant.EsConstant;
import com.es.service.IMallSearchService;
import com.es.vo.SearchParam;
import com.es.vo.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j
@Service
public class MallSearchServiceImpl implements IMallSearchService {

    @Autowired
    private RestHighLevelClient client;


    @Override
    public SearchResult search(SearchParam param) throws IOException {

        SearchRequest searchRequest = buildSearchRequrest(param);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        log.info("response:{}",search);
        return null;
    }





        /**
         * 准备检索请求
         */
    private SearchRequest buildSearchRequrest(SearchParam param) {
        //构建DSL语句
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        /**
         * 查询：过滤（按照属性、分类、品牌、价格区间、库存）
         */
        //构建boolQuery
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        //must模糊匹配
        if (!StringUtils.isEmpty(param.getKeyword())) {
            boolQuery.must(QueryBuilders.matchQuery("skuTitle", param.getKeyword()));
        }
        //按照三级分类id查询
        if (param.getCatalog3Id() != null) {
            boolQuery.filter(QueryBuilders.termQuery("catalogId", param.getCatalog3Id()));
        }
        //根据品牌id查询
        if (!CollectionUtils.isEmpty(param.getBrandId())) {
            boolQuery.filter(QueryBuilders.termsQuery("brandId", param.getBrandId()));
        }
        //按照属性查询
        if (!CollectionUtils.isEmpty(param.getAttrs())) {
            for (String attrStr : param.getAttrs()) {
                BoolQueryBuilder nestedBoolQuery = QueryBuilders.boolQuery();
                String[] s = attrStr.split("_");
                //检索属性id
                String attrId = s[0];
                //检索属性id对应的值
                String[] attrValue = s[1].split(":");
                nestedBoolQuery.must(QueryBuilders.termQuery("attrs.attrId", attrId));
                nestedBoolQuery.must(QueryBuilders.termQuery("attrs.attrValue", attrValue));
                //创建neste查询语句
                NestedQueryBuilder nestedQuery = QueryBuilders.nestedQuery("attrs", null, ScoreMode.None);
                boolQuery.filter(nestedQuery);
            }

        }
        //按照有库存进行查询(0：无库存；1：有库存)
        boolQuery.filter(QueryBuilders.termQuery("hasStock", param.getHasStock() == 1));

        //按照价格区间进行检索
        if (!StringUtils.isEmpty(param.getSkuPrice())) {
            /**
             * 价格区间用“_”连接；
             * 例如：0_50:价格区间为0到50
             *      _50：价格区间为小于等于50
             *      50_：价格区间为大于50
             */
            RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("skuPrice");
            String[] priceArray = param.getSkuPrice().split("_");
            if (priceArray.length == 2) {
                rangeQuery.gte(priceArray[0]).lte(priceArray[1]);
            } else if (priceArray.length == 1) {
                if (param.getSkuPrice().startsWith("_")) {
                    rangeQuery.lte(priceArray[0]);
                }

                if (param.getSkuPrice().endsWith("_")) {
                    rangeQuery.gte(priceArray[0]);
                }
            }
            boolQuery.filter(rangeQuery);
        }

        searchSourceBuilder.query(boolQuery);

        /**
         * 排序：分页、高亮
         */

        //排序
        if (!StringUtils.isEmpty(param.getSort())) {
            String sort = param.getSort();
            /**
             * 例如：sort=hotScore_asc/desc
             * "_"前是排序字段
             * "_"后升序还是降序
             */
            String[] s = sort.split("_");
            String sortKey = s[0];
            SortOrder order = s[1].equalsIgnoreCase("asc") ? SortOrder.ASC : SortOrder.DESC;
            searchSourceBuilder.sort(sortKey, order);
        }

        //分页
        searchSourceBuilder.from((param.getPageNum() - 1) * EsConstant.PRODUCT_PAGESIZE);
        searchSourceBuilder.size(EsConstant.PRODUCT_PAGESIZE);

        //高亮
        if (!StringUtils.isEmpty(param.getKeyword())) {
            HighlightBuilder builder = new HighlightBuilder();
            builder.field("skuTitle");
            builder.preTags("<b style='color:red'>");
            builder.postTags("</b>");
            searchSourceBuilder.highlighter(builder);
        }

        /**
         * 聚合分析
         */
        TermsAggregationBuilder brand_agg = AggregationBuilders.terms("brand_agg");
        //品牌聚合
        brand_agg.field("brandId").size(50);
        //品牌聚合的子聚合
        brand_agg.subAggregation(AggregationBuilders.terms("brand_name_agg").field("brandName").size(1));
        brand_agg.subAggregation(AggregationBuilders.terms("brand_img_agg").field("brandImg").size(1));
        //聚合品牌信息
        searchSourceBuilder.aggregation(brand_agg);
        //分类聚合
        TermsAggregationBuilder catalog_agg = AggregationBuilders.terms("catalog_agg").field("catalogId").size(20);
        catalog_agg.subAggregation(AggregationBuilders.terms("catalog_name_agg").field("catalogName").size(1));
        //聚合分类信息
        searchSourceBuilder.aggregation(catalog_agg);

        //属性聚合
        NestedAggregationBuilder attr_agg = AggregationBuilders.nested("attr_agg", "attrs");
        //聚合出当前所有的attrid
        TermsAggregationBuilder attr_id_agg = AggregationBuilders.terms("attr_id_agg").field("attrs.attrId");
        //聚合出当前attrid对应的名字
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_name_agg").field("attrs.attrName").size(1));
        //聚合分析出当前attr_id对应的所有可能的属性值
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_value_agg").field("attrs.attrValue").size(50));
        attr_agg.subAggregation(attr_id_agg);
        //聚合属性信息


        log.info("构建的的DSL:{}", searchSourceBuilder);// Create the Builder object


        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.PRODUCT_INDEX}, searchSourceBuilder);

        return searchRequest;
    }
}
