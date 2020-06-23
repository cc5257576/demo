package com.cc.common.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/20 16:54
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSmsInfoVO {

    private String token;

    private String phoneNo;

    private Short type;
}
