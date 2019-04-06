package com.dzg.springarcgis.service.impl;

import com.dzg.springarcgis.domain.User;
import com.dzg.springarcgis.mapper.UserMapper;
import com.dzg.springarcgis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int getIdByPhone(String phone) {
        return userMapper.getIdByPhone(phone);
    }

    @Override
    public User selectUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public User selectUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
