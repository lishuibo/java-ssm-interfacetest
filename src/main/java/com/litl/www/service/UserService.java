package com.litl.www.service;

import com.litl.www.pojo.User;

import java.util.List;

public interface UserService {
    int login(User user);

    int addUser(User user);

    List<User> getUserInfo(User user);

    int updateUser(User user);

    int deleteUser(User user);
}
