package com.cc.security.service;

import com.cc.security.dao.SysPermissionMapper;
import com.cc.security.pojo.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/10/16 15:56
 * Description:
 */
@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }
}