package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.MemberStatisticsInfo;
import com.example.member.mapper.MemberStatisticsInfoMapper;
import com.example.member.service.MemberStatisticsInfoService;
@Service
public class MemberStatisticsInfoServiceImpl implements MemberStatisticsInfoService{

    @Resource
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberStatisticsInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberStatisticsInfo record) {
        return memberStatisticsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(MemberStatisticsInfo record) {
        return memberStatisticsInfoMapper.insertSelective(record);
    }

    @Override
    public MemberStatisticsInfo selectByPrimaryKey(Long id) {
        return memberStatisticsInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MemberStatisticsInfo record) {
        return memberStatisticsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MemberStatisticsInfo record) {
        return memberStatisticsInfoMapper.updateByPrimaryKey(record);
    }

}
