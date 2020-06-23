package com.cc.provider.service.impl;

import com.cc.common.base.ResultBean;
import com.cc.common.domian.UserSmsInfoVO;
import com.cc.common.enums.Common;
import com.cc.common.enums.ResultCode;
import com.cc.common.enums.SmsType;
import com.cc.common.util.ObjectUtil;
import com.cc.common.util.RandomUtil;
import com.cc.provider.dao.UserInfoMapper;
import com.cc.provider.dao.UserSmsInfoMapper;
import com.cc.provider.pojo.UserInfoPO;
import com.cc.provider.pojo.UserSmsInfoPO;
import com.cc.provider.service.TokenService;
import com.cc.provider.service.UserSmsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;

import static com.cc.common.enums.ResultCode.*;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/20 15:18
 * Description:
 */
@Service
public class UserSmsInfoServiceImpl implements UserSmsInfoService {

    @Autowired
    UserSmsInfoMapper userSmsInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    TokenService tokenService;

    @Override
    public ResultBean send(UserSmsInfoVO record) {
        SmsType smsType = SmsType.getSmsType(record.getType());
        if(ObjectUtil.isEmpty(smsType))
            return new ResultBean(UserInfoCode.SMS_TYPE_NULL.getCode(), UserInfoCode.SMS_TYPE_NULL.getMsg());
        UserSmsInfoPO smsInfoPO = new UserSmsInfoPO();
        smsInfoPO.setType(smsType.getType());
        smsInfoPO.setStatus(Common.Status.NO.getVal());
        smsInfoPO.setIsUse(Common.Status.NO.getVal());
        //短信登陆逻辑处理
        if(smsType.equals(SmsType.LOGIN)){
            if(ObjectUtil.isEmpty(record.getPhoneNo()))
                return new ResultBean(UserInfoCode.PHONE_NO_NULL.getCode(), UserInfoCode.PHONE_NO_NULL.getMsg());
            smsInfoPO.setPhoneNo(record.getPhoneNo());
            smsInfoPO.setVerifyCode(RandomUtil.randomNumbers(6));
            smsInfoPO.setContent(smsType.getSmsTemplate(smsInfoPO.getVerifyCode()));
        }
        //传入token有手机号的用户
        Integer userId = tokenService.getUserIdByToken(record.getToken());
        UserInfoPO userInfoPO = userInfoMapper.get(userId);
        if(ObjectUtil.isEmpty(userInfoPO))
            return new ResultBean(UserInfoCode.USER_INFO_NULL.getCode(), UserInfoCode.USER_INFO_NULL.getMsg());
        smsInfoPO.setUserId(userInfoPO.getId());
        smsInfoPO.setPhoneNo(userInfoPO.getPhoneNo());
        smsInfoPO.setContent(smsType.getSmsTemplate(null));
        int num = userSmsInfoMapper.save(smsInfoPO);
        if(num == 0)
            return ResultBean.fail();


        return ResultBean.is(num);
    }
}
