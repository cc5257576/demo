package com.cc.stream.controller;

import com.cc.stream.model.Company;
import com.cc.stream.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/26 10:59
 * Description:
 */
@RequestMapping("msg")
@RestController
public class MessageController {

    @Resource
    IMessageProvider messageProvider;

    @RequestMapping("/send")
    public void send(Company company){
        messageProvider.send(company);
    }

}
