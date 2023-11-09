package com.es.service;

import com.gulimall.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

public interface IEsService {


    /**
     * 批量添加文档数据
     * @param list：批量文档数据
     * @throws IOException
     */
    boolean batchCreateDocument(List<SkuEsModel> list) throws IOException;

}
