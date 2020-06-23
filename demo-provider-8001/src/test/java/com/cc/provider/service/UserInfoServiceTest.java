package com.cc.provider.service;

import com.alibaba.fastjson.JSON;
import com.cc.common.base.ResultBean;
import com.cc.common.base.TokenBean;
import com.cc.common.domian.UserInfoBO;
import com.cc.common.domian.UserInfoVO;
import com.cc.common.enums.LoginType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void register() {
        UserInfoVO vo = new UserInfoVO();
        vo.setAccount("chencheng");
        vo.setPassword("123456");
        userInfoService.register(vo);
    }

    @Test
    public void login(){
        UserInfoVO vo = new UserInfoVO();
        vo.setPhoneNo("15817375451");
        vo.setVerifyCode("123456");
        vo.setLoginType(LoginType.PHONE.getType());
        ResultBean resultBean = userInfoService.login(vo);
        System.out.println(JSON.toJSONString(resultBean));
    }

    @Test
    public void get(){
        Integer userId = 3;
        UserInfoBO userInfoBO = userInfoService.get(userId);
        System.out.println(JSON.toJSONString(userInfoBO));
    }
}