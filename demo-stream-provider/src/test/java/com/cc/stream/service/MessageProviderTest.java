package com.cc.stream.service;

import com.cc.stream.DemoStreamProviderApplication;
import com.cc.stream.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoStreamProviderApplication.class)
@WebAppConfiguration
public class MessageProviderTest {

    @Autowired
    private IMessageProvider messageProvider;

    @Test
    public void send() {
        Company company = new Company();
        company.setTitle("测试标题");
        company.setNote("hello word");
        this.messageProvider.send(company); // 消息发送
    }
}