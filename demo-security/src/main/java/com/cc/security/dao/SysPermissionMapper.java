package com.cc.security.dao;

import com.cc.security.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/10/16 15:55
 * Description:
 */
@Mapper
public interface SysPermissionMapper {
    @Select("SELECT * FROM sys_permission WHERE role_id=#{roleId}")
    List<SysPermission> listByRoleId(Integer roleId);
}
