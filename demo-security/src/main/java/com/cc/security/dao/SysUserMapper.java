package com.cc.security.dao;

import com.cc.security.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);
}
