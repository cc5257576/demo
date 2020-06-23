package com.cc.provider.pojo;

import com.cc.common.domian.UserInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/23 15:55
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoPO {

    private Integer id;

    private String account;

    private String password;

    private String petName;

    private String portraitFid;

    private Short type;

    private Date lastTime;

    private String qqOpenId;

    private String wechatUnionId;

    private Date wechatTime;

    private String remark;

    private String inviteCode;

    private String sourceType;

    private Date disableTime;

    private Integer channelId;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    public AccountInfoPO(UserInfoVO record) {
        this.account = record.getAccount();
        this.password = record.getPassword();
        this.channelId = record.getChannelId();
    }
}
