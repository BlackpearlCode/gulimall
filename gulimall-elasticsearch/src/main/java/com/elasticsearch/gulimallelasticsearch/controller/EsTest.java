package com.elasticsearch.gulimallelasticsearch.controller;


import co.elastic.clients.elasticsearch.ElasticsearchClient;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@RestController
public class EsTest {

    @Autowired
    private ElasticsearchClient client;

    //查询索引是否存在
    @RequestMapping("/test1")
    public boolean test1() throws IOException {
        boolean bool = client.indices().exists(e -> e.index("test")).value();
        return bool;
    }

    //查询索引下的所有信息
    @RequestMapping("/test2")
    public String test() throws IOException, NoSuchFieldException {
        SearchResponse<Object> searchResponse = client.search(builder -> builder
                        .index("test_query"),
                Object.class);
        List<Hit<Object>> hits = searchResponse.hits().hits();
        List<Object > list=new LinkedList<>();
        hits.forEach(x->list.add( x.source()));

        return list.toString();
    }
}
