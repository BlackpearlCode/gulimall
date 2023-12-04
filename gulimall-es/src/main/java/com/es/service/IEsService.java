package com.es.service;

import com.gulimall.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

public interface IEsService {


    /**
     * 商品保存
     * @param skuEsModels
     * @return
     * @throws IOException
     */
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;

}
