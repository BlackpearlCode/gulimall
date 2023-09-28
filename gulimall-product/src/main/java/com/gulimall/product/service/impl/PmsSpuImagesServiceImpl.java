package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsSpuImages;
import com.gulimall.product.mapper.PmsSpuImagesMapper;
import com.gulimall.product.service.PmsSpuImagesService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PmsSpuImagesServiceImpl implements PmsSpuImagesService {

    @Resource
    private PmsSpuImagesMapper pmsSpuImagesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSpuImagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSpuImages record) {
        return pmsSpuImagesMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSpuImages record) {
        return pmsSpuImagesMapper.insertSelective(record);
    }

    @Override
    public PmsSpuImages selectByPrimaryKey(Long id) {
        return pmsSpuImagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSpuImages record) {
        return pmsSpuImagesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSpuImages record) {
        return pmsSpuImagesMapper.updateByPrimaryKey(record);
    }

    @Override
    public void batchSave(Long id, List<String> images) {
        if(null==images || images.size()<0){

        }else{
            List<PmsSpuImages> spuImages = images.stream().map(img -> {
                PmsSpuImages spuImage = new PmsSpuImages();
                spuImage.setSpuId(id);
                spuImage.setImgUrl(img);
                return spuImage;
            }).collect(Collectors.toList());

            pmsSpuImagesMapper.batchSave(spuImages);
        }
    }

}
