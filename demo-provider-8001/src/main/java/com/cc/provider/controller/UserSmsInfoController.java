package com.cc.provider.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/20 15:16
 * Description:
 */
@Log4j2
@RequestMapping("user/sms")
@RestController
public class UserSmsInfoController {

    public Object send(){
        return null;
    }
}
