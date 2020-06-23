package com.cc.security.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 20:05
 * Description:
 */
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;
}
