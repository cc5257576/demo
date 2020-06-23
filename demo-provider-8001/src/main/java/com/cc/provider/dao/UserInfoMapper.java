package com.cc.provider.dao;

import com.cc.common.domian.UserInfoBO;
import com.cc.provider.pojo.UserInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    int save(UserInfoPO record);

    UserInfoPO get(Integer id);

    UserInfoBO getById(Integer id);

    UserInfoPO getByPhoneNo(String phoneNo);
}
