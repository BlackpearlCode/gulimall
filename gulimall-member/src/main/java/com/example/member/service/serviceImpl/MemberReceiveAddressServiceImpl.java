package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.mapper.MemberReceiveAddressMapper;
import com.example.member.entity.MemberReceiveAddress;
import com.example.member.service.MemberReceiveAddressService;

import java.util.List;

@Service
public class MemberReceiveAddressServiceImpl implements MemberReceiveAddressService{

    @Resource
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberReceiveAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberReceiveAddress record) {
        return memberReceiveAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(MemberReceiveAddress record) {
        return memberReceiveAddressMapper.insertSelective(record);
    }

    @Override
    public MemberReceiveAddress selectByPrimaryKey(Long id) {
        return memberReceiveAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MemberReceiveAddress record) {
        return memberReceiveAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MemberReceiveAddress record) {
        return memberReceiveAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MemberReceiveAddress> getAddress(Long memberId) {
        if(memberId!=null){
            return memberReceiveAddressMapper.selectByMemberId(memberId);
        }
        return null;
    }

}
