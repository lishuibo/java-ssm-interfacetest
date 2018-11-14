package com.litl.www.service.impl;

import com.litl.www.dao.UserDao;
import com.litl.www.pojo.User;
import com.litl.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int login(User user) {
        return userDao.login(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getUserInfo(User user) {
        return userDao.getUserInfo(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
