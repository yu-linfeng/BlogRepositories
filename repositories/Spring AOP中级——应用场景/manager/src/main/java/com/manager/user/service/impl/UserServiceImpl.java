package com.manager.user.service.impl;

import com.manager.user.dao.IUserDao;
import com.manager.user.pojo.User;
import com.manager.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理服务实现类
 * Created by Kevin on 2017/10/24.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> queryUsers() {
        return userDao.queryUsers();
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0;
    }

    @Override
    public User queryUserById(long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public boolean updateUserById(User user) {
        return userDao.updateUserById(user) > 0;
    }

    @Override
    public boolean deleteUserById(long id) {
        return userDao.deleteUserById(id) > 0;
    }
}
