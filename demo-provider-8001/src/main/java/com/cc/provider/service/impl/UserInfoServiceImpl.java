package com.cc.provider.service.impl;

import com.cc.common.base.ResultBean;
import com.cc.common.domian.UserInfoBO;
import com.cc.common.domian.UserInfoVO;
import com.cc.common.enums.*;
import com.cc.common.util.ObjectUtil;
import com.cc.common.util.RandomUtil;
import com.cc.provider.dao.AccountInfoMapper;
import com.cc.provider.dao.UserInfoMapper;
import com.cc.provider.dao.UserSmsInfoMapper;
import com.cc.provider.pojo.AccountInfoPO;
import com.cc.provider.pojo.UserInfoPO;
import com.cc.provider.pojo.UserSmsInfoPO;
import com.cc.provider.service.TokenService;
import com.cc.provider.service.UserInfoService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/23 16:11
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserSmsInfoMapper userSmsInfoMapper;

    @Autowired
    TokenService tokenService;

    @Override
    @Transactional
    public int register(UserInfoVO record) {
        AccountInfoPO accountInfoPO = new AccountInfoPO(record);
        accountInfoPO.setType(AccountType.USER.getType());
        accountInfoPO.setInviteCode(RandomUtil.randomStringUpperLower(8));
        accountInfoPO.setChannelId(1);
        accountInfoMapper.save(accountInfoPO);
        UserInfoPO userInfoPO = new UserInfoPO(record);
        userInfoPO.setAccountId(accountInfoPO.getId());
        userInfoPO.setStatus(UserStatus.NORMAL.getStatus());
        userInfoPO.setType(UserType.REAL.getType());
        userInfoMapper.save(userInfoPO);
        //此处根据用户角色创建token, 根据不同的token转发到不同环境
        return userInfoPO.getId();
    }

    @Override
    @Transactional
    public ResultBean login(UserInfoVO record){
        if(ObjectUtil.isEmpty(record))
            return new ResultBean(ResultCode.DataValidateCode.NULL.getCode(), ResultCode.DataValidateCode.NULL.getMsg());
        LoginType loginType = LoginType.getLoginType(record.getLoginType());
        if(ObjectUtil.isEmpty(loginType))
            return new ResultBean(ResultCode.UserInfoCode.LOGIN_TYPE_NULL.getCode(), ResultCode.UserInfoCode.LOGIN_TYPE_NULL.getMsg());
        switch (loginType){
            case PHONE:
                return phoneLogin(record);
        }
        return ResultBean.fail();
    }

    private ResultBean phoneLogin(UserInfoVO record){
        if(ObjectUtil.isEmpty(record.getPhoneNo()))
            return new ResultBean(ResultCode.UserInfoCode.PHONE_NO_NULL.getCode(), ResultCode.UserInfoCode.PHONE_NO_NULL.getMsg());
        if(ObjectUtil.isEmpty(record.getVerifyCode()))
            return new ResultBean(ResultCode.UserInfoCode.VERIFY_CODE_NULL.getCode(), ResultCode.UserInfoCode.VERIFY_CODE_NULL.getMsg());
        UserSmsInfoPO smsParamsPO = new UserSmsInfoPO();
        smsParamsPO.setPhoneNo(record.getPhoneNo());
        smsParamsPO.setVerifyCode(record.getVerifyCode());
        smsParamsPO.setType(SmsType.LOGIN.getType());
        smsParamsPO.setStatus(Common.Status.YES.getVal());
        smsParamsPO.setIsUse(Common.Status.NO.getVal());
        int valiData = userSmsInfoMapper.validateSms(smsParamsPO);
        if(valiData == 0)
            return new ResultBean(ResultCode.UserInfoCode.VERIFY_CODE_ERROR.getCode(), ResultCode.UserInfoCode.VERIFY_CODE_ERROR.getMsg());
        UserInfoPO userInfoPO = userInfoMapper.getByPhoneNo(record.getPhoneNo());
        int userId = 0;
        if(ObjectUtil.isEmpty(userInfoPO)){
            userId = register(record);
        }else{
            userId = userInfoPO.getId();
        }
        if(userId > 0)
            return ResultBean.ok(tokenService.generateToken(userId));
        return ResultBean.fail();
    }

    @Override
    public UserInfoBO get(Integer id){
        return userInfoMapper.getById(id);
    }

    @Override
    public ResultBean validatePhoneNo(UserInfoVO record) {
        return null;
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(10000000);
//        for (int i=0; i<100000000; i++) {
//            String key = RandomUtil.randomStringUpperLower(8);
//            if(list.contains(key)){
//                System.out.println(key);
//                break;
//            }
//            list.add(key);
//            System.out.println(i);
//        }
//        System.out.println(list.size());
    }
}
