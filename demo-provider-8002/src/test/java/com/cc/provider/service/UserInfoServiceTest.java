package com.cc.provider.service;

import com.cc.common.domian.UserInfoVO;
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
        vo.setAccount("chencheng0609");
        vo.setPassword("654321");
        userInfoService.register(vo);
    }
}