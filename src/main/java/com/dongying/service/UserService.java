package com.dongying.service;

import com.dongying.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();
    UserEntity getUserById(Integer id);
}
