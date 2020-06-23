package com.cc.provider.pojo;

import com.cc.common.domian.UserInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/23 16:13
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoPO {

    private Integer id;

    private Integer accountId;

    private String phoneNo;

    private String fullName;

    private Integer age;

    private Short sex;

    private Short status;

    private String province;

    private String city;

    private String county;

    private String street;

    private String address;

    private String cardNo;

    private String cardPositiveFid;

    private String cardNegativeFid;

    private Short cardStatus;

    private Short type;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    public UserInfoPO(UserInfoVO record) {

    }
}
