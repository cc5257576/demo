package com.cc.common.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.cc.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/19 19:20
 * Description:
 */
@Data
@NoArgsConstructor
public class TokenBean implements Serializable {

    public String token;

    private Date createTime;

    private Date expireTime;

    private String refreshToken;

    @JsonIgnore
    @JSONField(serialize = false)
    public Integer userId;

    @JsonIgnore
    @JSONField(serialize = false)
    public Integer channelId;

    public TokenBean(String token, Date createTime, String refreshToken, Integer userId, Integer channelId) {
        this.token = token;
        this.createTime = createTime;
        this.expireTime = DateUtil.offsetHour(createTime, 2);
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.channelId = channelId;
    }
}
