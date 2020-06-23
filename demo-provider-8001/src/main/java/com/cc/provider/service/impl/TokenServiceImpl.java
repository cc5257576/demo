package com.cc.provider.service.impl;

import com.cc.common.base.TokenBean;
import com.cc.common.constant.UserConst;
import com.cc.common.util.ObjectUtil;
import com.cc.common.util.RandomUtil;
import com.cc.common.util.crypto.digest.DigestUtil;
import com.cc.provider.service.RedisService;
import com.cc.provider.service.TokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/18 17:44
 * Description:
 */
@Service
@Log4j2
public class TokenServiceImpl implements TokenService {

    @Autowired
    RedisService redisService;

    @Override
    public TokenBean generateToken(Integer userId) {
        String random = RandomUtil.randomStringUpper(RandomUtil.randomInt(8));
        String token  = DigestUtil.md5Hex(random + userId);
//        String refreshToken = DigestUtil.md5Hex(userId + random);
        TokenBean tokenBean = new TokenBean(token, new Date(), null, userId, null);
        String tokenKey = UserConst.TOKEN_USER + token;
        redisService.set(tokenKey, tokenBean, tokenBean.getExpireTime().getTime(), TimeUnit.MILLISECONDS);
        String userKey = UserConst.USER_TOKEN + userId;
        redisService.set(userKey, token, tokenBean.getExpireTime().getTime(), TimeUnit.MILLISECONDS);
//        redisService.set(refreshToken,tokenBean, 1, TimeUnit.DAYS);
        return tokenBean;
    }

    @Override
    public Integer getUserIdByToken(String token) {
        TokenBean tokenBean = getTokenBeanByToken(token);
        return ObjectUtil.isNotEmpty(tokenBean) ? tokenBean.getUserId() : null;
    }

    public boolean validateLogin(String token, Integer userId){
        TokenBean tokenBean = getTokenBeanByToken(token);
        return tokenBean.getUserId().equals(userId) && token.equals(getTokenByUserId(userId));
    }

    /**
     * 验证token是否还有效
     * @param token
     * @param userId
     * @return
     */
    public boolean validateToken(String token, Integer userId) {
        TokenBean tokenBean = getTokenBeanByToken(token);
        return userId.equals(tokenBean.getUserId()) && !isTokenExpired(token);
    }

    @Override
    public void refreshToken(String token) {

    }

    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateByToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateByToken(String token) {
        TokenBean tokenBean = getTokenBeanByToken(token);
        return tokenBean.getExpireTime();
    }

    private TokenBean getTokenBeanByToken(String token){
        String tokenKey = UserConst.TOKEN_USER + token;
        return (TokenBean) redisService.get(tokenKey);
    }

    private String getTokenByUserId(Integer userId){
        String userKey = UserConst.USER_TOKEN + userId;
        Object obj = redisService.get(userKey);
        return ObjectUtil.isNotEmpty(obj) ? obj.toString() : null;
    }
}
