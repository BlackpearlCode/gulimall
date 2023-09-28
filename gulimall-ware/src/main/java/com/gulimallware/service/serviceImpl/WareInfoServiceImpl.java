package com.gulimallware.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulimall.common.utils.PageEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.mapper.WareInfoMapper;
import com.gulimallware.entity.WareInfo;
import com.gulimallware.service.WareInfoService;

import java.util.List;
import java.util.Map;

@Service
public class WareInfoServiceImpl implements WareInfoService{

    @Resource
    private WareInfoMapper wareInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return wareInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WareInfo record) {
        return wareInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(WareInfo record) {
        return wareInfoMapper.insertSelective(record);
    }

    @Override
    public WareInfo selectByPrimaryKey(Long id) {
        return wareInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WareInfo record) {
        return wareInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WareInfo record) {
        return wareInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageEntity getAll(Map<String, Object> params) {

        List<WareInfo> wareInfoList=wareInfoMapper.getAll(params);
        PageHelper.startPage(Integer.parseInt((String) params.get("page")),Integer.parseInt((String) params.get("limit")));
        PageInfo<WareInfo> pageInfo=new PageInfo<>(wareInfoList);
        PageEntity pageEntity=new PageEntity(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        return pageEntity;
    }

    @Override
    public void batchDeleteById(List<Long> ids) {
        wareInfoMapper.batchDeleteById(ids);
    }

}
