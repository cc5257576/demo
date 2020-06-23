package com.cc.common.domian;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/30 14:21
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBO {

    private Integer Id;

    private String account;

    private String password;

    private String phoneNo;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
