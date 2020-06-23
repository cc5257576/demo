package com.cc.provider.dao;

import com.cc.provider.pojo.AccountInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountInfoMapper {

    int save(AccountInfoPO record);

    AccountInfoPO get(Integer id);
}
