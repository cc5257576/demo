package com.cc.consumer.controller;

import com.cc.common.domian.UserInfoBO;
import com.cc.consumer.service.UserInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/30 17:14
 * Description:
 */
@RequestMapping("user")
@RestController
@RefreshScope
public class UserInfoController {

    @Value("${info.username}")
    private String username;

    @Value("${info.password}")
    private String password;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/get")
    @HystrixCommand(fallbackMethod="getFallback")
    public Object get(Integer userId){
        UserInfoBO userInfoBO = userInfoService.get(userId);
//        if(userInfoBO != null)
//            throw new RuntimeException();
        return userInfoBO;
    }
    @RequestMapping("/query")
    public Object query(@RequestBody Map<String,String> param){
        Object userId = param.get("userId");
        UserInfoBO userInfoBO = userInfoService.get(Integer.valueOf(userId.toString()));
//        if(userInfoBO != null)
//            throw new RuntimeException();
        return userInfoBO;
    }

    @RequestMapping("/getUser")
    public Object getUser(){
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

    public Object getFallback(Integer userId){

        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setAccount("test");
        userInfoBO.setPassword("test");
        userInfoBO.setCreateTime(new Date());
        return userInfoBO;
    }
}
