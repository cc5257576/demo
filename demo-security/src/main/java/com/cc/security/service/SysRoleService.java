package com.cc.security.service;

import com.cc.security.dao.SysRoleMapper;
import com.cc.security.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 20:07
 * Description:
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }

    public SysRole selectByName(String name){
        return roleMapper.selectByName(name);
    }
}