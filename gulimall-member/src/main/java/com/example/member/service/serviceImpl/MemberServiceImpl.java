package com.example.member.service.serviceImpl;

import com.example.member.entity.MemberLevel;
import com.example.member.exception.PhoneExistException;
import com.example.member.exception.UsernameExistException;
import com.example.member.service.MemberLevelService;
import com.example.member.vo.MemberLoginVo;
import com.example.member.vo.MemberRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.Member;
import com.example.member.mapper.MemberMapper;
import com.example.member.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{

    @Resource
    private MemberMapper memberMapper;
    @Autowired
    private MemberLevelService memberLevelService;

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

    @Override
    public void regist(MemberRegistVo vo) {
        Member member = new Member();
        //设置默认等级
        MemberLevel memberLevel=memberLevelService.getDefaultLevel();
        member.setLevelId(memberLevel.getId());
        //检查用户名和手机号是否唯一。为了让上层cotroller能感知到异常
        checkPhoneUnique(vo.getPhone());
        checkUsernameUnique(vo.getUserName());

        //设置手机号
        member.setMobile(vo.getPhone());
        //设置用户名
        member.setUsername(vo.getUserName());
        //设置密码;密码加密存储
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(vo.getPassword());
        member.setPassword(encode);
        //保存
        memberMapper.insertSelective(member);
    }

    @Override
    public void checkPhoneUnique(String phone) throws PhoneExistException{
        int num = memberMapper.selectPhoneISExist(phone);
        if(num>0){
            throw new PhoneExistException();
        }
    }

    @Override
    public void checkUsernameUnique(String username) throws UsernameExistException{
        int num = memberMapper.seleatUsernameISExist(username);
        if(num>0){
            throw new UsernameExistException();
        }

    }

    @Override
    public Member login(MemberLoginVo vo) {
        Member memberInfo=memberMapper.selectUsernameOrPhone(vo);
        if(memberInfo==null){
            return null;
        }
        //获取数据库的password字段
        String passwordDB = memberInfo.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //2.密码匹配
        boolean matches = passwordEncoder.matches(vo.getPassword(), passwordDB);
        if(!matches){
            return null;
        }
        return memberInfo;
    }

}
