package com.cc.provider.service;

import com.alibaba.fastjson.JSON;
import com.cc.provider.pojo.UserInfoPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisService redisService;

    public static String key = "cc";

    public static String value = "500";

    public static long time = 10l;

    public static TimeUnit timeUnit = TimeUnit.SECONDS;

    @Test
    public void set() {
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setId(5);
        userInfoPO.setPhoneNo("15817375451");
        userInfoPO.setCreateTime(new Date());
        redisService.set(key, userInfoPO);
    }

    @Test
    public void set1() {
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setId(5);
        userInfoPO.setPhoneNo("15817375451");
        userInfoPO.setCreateTime(new Date());
        redisService.set(key, userInfoPO, 30, TimeUnit.SECONDS);
    }

    @Test
    public void get() {
       Object obj =  redisService.get(key);
//       Map<String, String> map = (Map<String, String>)obj;
        System.out.println(obj);
    }

    @Test
    public void expire() {
        Boolean bool = redisService.expire(key, time, timeUnit);
        System.out.println(bool);
    }

    @Test
    public void delete(){
        Boolean bool = redisService.delete(key);
        System.out.println(bool);
    }


    @Test
    public void increment() {
    }
}