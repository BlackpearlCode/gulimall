package com.example.member.controller;

import com.example.member.entity.MemberReceiveAddress;
import com.example.member.service.MemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member/memberreceiveaddress")
public class MemberReceiveAddressController {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    @GetMapping("/{memberId}/getAddress")
    public List<MemberReceiveAddress> getAddress(@PathVariable("memberId") Long memberId){
        return memberReceiveAddressService.getAddress(memberId);
    }
}
