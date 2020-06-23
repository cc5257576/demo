package com.cc.common.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/23 16:51
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {

    private Integer id;

    private String account;

    private String password;

    private String phoneNo;

    private String verifyCode;

    /**
     * 1:手机登陆,2:微信登陆
     */
    private Short loginType;

    private Integer channelId;
}
