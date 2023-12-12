package com.gulimall.auth.feign;

import com.gulimall.common.to.SkuReductionTo;
import com.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "third-party")
public interface ThirdPartyFeginService {

    @GetMapping("/sms/sendCode")
    Result sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) throws Exception;


}
