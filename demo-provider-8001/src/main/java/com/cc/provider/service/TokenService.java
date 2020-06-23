package com.cc.provider.service;

import com.cc.common.base.TokenBean;

public interface TokenService {

    TokenBean generateToken(Integer userId);

    Integer getUserIdByToken(String token);

    void refreshToken(String token);
}
