package com.cc.security.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 20:04
 * Description:
 */
@Data
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;
}
