package com.cc.provider.service;

import com.cc.common.base.ResultBean;
import com.cc.common.domian.UserSmsInfoVO;

public interface UserSmsInfoService {

    ResultBean send(UserSmsInfoVO record);
}
