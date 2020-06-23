package com.cc.consumer.service;

import com.cc.common.domian.UserInfoBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("demo-provider")
public interface UserInfoService {

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    UserInfoBO get(@RequestParam("userId")Integer userId);
}
