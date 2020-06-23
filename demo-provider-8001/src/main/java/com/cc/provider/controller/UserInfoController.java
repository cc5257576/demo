package com.cc.provider.controller;

import com.cc.common.base.BaseController;
import com.cc.common.base.ResultBean;
import com.cc.common.domian.UserInfoVO;
import com.cc.common.enums.ResultCode.*;
import com.cc.common.util.ObjectUtil;
import com.cc.provider.service.UserInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get")
    public Object get(Integer userId){
        log.info("get: " + userId);
        return userInfoService.get(userId);
    }

    public Object validatePhoneNo(UserInfoVO vo){
        return null;
    }

}
