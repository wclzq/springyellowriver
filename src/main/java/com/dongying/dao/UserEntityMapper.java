package com.dongying.dao;

import com.dongying.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<UserEntity> getAllUser();
    UserEntity getUserById(Integer id);
}