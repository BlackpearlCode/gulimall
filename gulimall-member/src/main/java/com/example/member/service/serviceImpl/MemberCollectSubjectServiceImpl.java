package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.MemberCollectSubject;
import com.example.member.mapper.MemberCollectSubjectMapper;
import com.example.member.service.MemberCollectSubjectService;
@Service
public class MemberCollectSubjectServiceImpl implements MemberCollectSubjectService{

    @Resource
    private MemberCollectSubjectMapper memberCollectSubjectMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberCollectSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberCollectSubject record) {
        return memberCollectSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(MemberCollectSubject record) {
        return memberCollectSubjectMapper.insertSelective(record);
    }

    @Override
    public MemberCollectSubject selectByPrimaryKey(Long id) {
        return memberCollectSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MemberCollectSubject record) {
        return memberCollectSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MemberCollectSubject record) {
        return memberCollectSubjectMapper.updateByPrimaryKey(record);
    }

}
