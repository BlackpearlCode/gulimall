package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.MemberCollectSpu;
import com.example.member.mapper.MemberCollectSpuMapper;
import com.example.member.service.MemberCollectSpuService;
@Service
public class MemberCollectSpuServiceImpl implements MemberCollectSpuService{

    @Resource
    private MemberCollectSpuMapper memberCollectSpuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberCollectSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberCollectSpu record) {
        return memberCollectSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(MemberCollectSpu record) {
        return memberCollectSpuMapper.insertSelective(record);
    }

    @Override
    public MemberCollectSpu selectByPrimaryKey(Long id) {
        return memberCollectSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MemberCollectSpu record) {
        return memberCollectSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MemberCollectSpu record) {
        return memberCollectSpuMapper.updateByPrimaryKey(record);
    }

}
