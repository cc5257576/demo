package com.cc.stream.service.impl;

import com.alibaba.fastjson.JSON;
import com.cc.stream.model.Company;
import com.cc.stream.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/26 10:07
 * Description:
 */

@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public void send(Company company) {
        System.out.println(JSON.toJSON(company));
        this.output.send(MessageBuilder.withPayload(company).build()); // 创建并发送消息
    }
}
