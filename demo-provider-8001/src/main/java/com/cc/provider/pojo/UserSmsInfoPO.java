package com.cc.provider.pojo;

import com.cc.common.domian.UserSmsInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/18 15:02
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSmsInfoPO {

    private Integer id;

    private Integer userId;

    private String phoneNo;

    private String content;

    private String verifyCode;

    private Short type;

    private Short status;

    private Short isUse;

    private Short channel;

    private Date createTime;

    private Date updateTime;
}
