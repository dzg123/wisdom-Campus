package com.dzg.springarcgis.service;

import com.dzg.springarcgis.domain.User;

public interface UserService {
    User selectUserByUserName(String username);
    User selectUserByPhone(String phone);
    int getIdByPhone(String phone);

    int insertUser(User user);
}
