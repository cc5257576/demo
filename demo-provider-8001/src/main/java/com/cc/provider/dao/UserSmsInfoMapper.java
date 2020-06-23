package com.cc.provider.dao;

import com.cc.provider.pojo.UserSmsInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSmsInfoMapper {

    int save(UserSmsInfoPO record);

    UserSmsInfoPO get(UserSmsInfoPO record);

    int validateSms(UserSmsInfoPO record);
}
