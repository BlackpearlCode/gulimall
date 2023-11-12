package com.es.service.serviceImpl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.bulk.CreateOperation;
import com.es.constant.EsConstant;
import com.es.service.IEsService;
import com.gulimall.common.es.SkuEsModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EsServiceImpl implements IEsService {
    @Autowired
    private ElasticsearchClient client;


    @Override
    public boolean batchCreateDocument(List<SkuEsModel> list) throws IOException {
        //将SkuEsModel模型集合转换成BulkOperation类型的集合
        List<BulkOperation> bulkOperations=new LinkedList<>();
        for(int i=0;i<list.size();i++){
            CreateOperation<SkuEsModel> operation = new CreateOperation.Builder<SkuEsModel>()
                    .index(EsConstant.PRODUCT_INDEX)
                    .id(String.valueOf(list.get(i).getSkuId()))
                    .document(list.get(i))
                    .build();
            BulkOperation bulkOperation = new BulkOperation.Builder().create(operation).build();
            bulkOperations.add(bulkOperation);
        }

        BulkRequest bulkRequest = new BulkRequest.Builder()
                .operations(bulkOperations)
                .build();
        BulkResponse bulk = client.bulk(bulkRequest);
        boolean b = bulk.errors();
        if(!b){
            log.info("商品上架成功");
            return b;
        }
        //TODO 如果批量出错
        List<String> collect = bulk.items().stream().map(item -> {
            return item.id();
        }).collect(Collectors.toList());
        log.info("商品上架错误：{}，返回数据：{}",collect,bulk);
        return b;
    }

}
