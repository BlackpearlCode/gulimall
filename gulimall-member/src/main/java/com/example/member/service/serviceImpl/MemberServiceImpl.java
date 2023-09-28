package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.Member;
import com.example.member.mapper.MemberMapper;
import com.example.member.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Member record) {
        return memberMapper.insert(record);
    }

    @Override
    public int insertSelective(Member record) {
        return memberMapper.insertSelective(record);
    }

    @Override
    public Member selectByPrimaryKey(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Member record) {
        return memberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Member record) {
        return memberMapper.updateByPrimaryKey(record);
    }

}
