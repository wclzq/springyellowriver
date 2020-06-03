package com.dongying.service.serviceImpl;

import com.dongying.dao.UserEntityMapper;
import com.dongying.entity.UserEntity;
import com.dongying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;
    @Override
    public List<UserEntity> getAllUser() {


        return  userEntityMapper.getAllUser();
    }
    @Override
    public UserEntity getUserById(Integer id) {
        return userEntityMapper.getUserById(id);
    }

}
