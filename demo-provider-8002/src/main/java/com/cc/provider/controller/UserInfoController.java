package com.cc.provider.controller;

import com.cc.common.base.BaseController;
import com.cc.provider.service.UserInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/30 16:18
 * Description:
 */
@Log4j2
@RequestMapping("user")
@RestController
public class UserInfoController extends BaseController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/sessionId")
    public Object id(HttpServletRequest request) {
        return request.getSession().getId() ;
    }

    @GetMapping("/get")
    public Object get(Integer userId){
        log.info("get: " + userId);
        return userInfoService.get(userId);
    }
}
