package com.gulimall.auth.feign;

import com.gulimall.auth.vo.UserRegistVo;
import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "gulimall-member")
public interface MemberFeignService {

    @RequestMapping("/member/member/regist")
    Result regist(@RequestBody UserRegistVo vo);
}
