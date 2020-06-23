package com.cc.stream.rabbit.consumer;

import com.cc.stream.model.Company;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/26 10:48
 * Description:
 */
@Component
@EnableBinding(Sink.class)
public class MessageListener {

    @StreamListener(Sink.INPUT)
    public void input(Object message) {
        System.err.println("【*** 消息接收 ***】" + message.toString());
    }
}
