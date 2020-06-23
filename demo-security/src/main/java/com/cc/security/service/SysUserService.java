package com.cc.security.service;

import com.cc.security.dao.SysUserMapper;
import com.cc.security.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 20:07
 * Description:
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
