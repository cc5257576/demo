package com.cc.security.service;

import com.cc.security.dao.SysUserRoleMapper;
import com.cc.security.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 20:08
 * Description:
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
