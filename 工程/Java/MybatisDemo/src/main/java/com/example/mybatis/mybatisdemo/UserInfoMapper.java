package com.example.mybatis.mybatisdemo;

import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper {
    public UserInfo selectUser(int Id);
}
