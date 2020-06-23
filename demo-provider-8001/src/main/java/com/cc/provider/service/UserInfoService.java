package com.cc.provider.service;


import com.cc.common.base.ResultBean;
import com.cc.common.domian.UserInfoBO;
import com.cc.common.domian.UserInfoVO;

public interface UserInfoService {

    int register(UserInfoVO record);

    UserInfoBO get(Integer userId);

    ResultBean login(UserInfoVO record);

    ResultBean validatePhoneNo(UserInfoVO record);
}
