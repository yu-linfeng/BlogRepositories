package com.manager.user.service;

import com.manager.user.pojo.User;

import java.util.List;

/**
 * 用户管理服务接口
 * Created by Kevin on 2017/10/24.
 */
public interface IUserService {
    /**
     * 查询所有用户
     * @return 用户List
     */
    List<User> queryUsers();

    /**
     * 新增用户
     * @param user 用户
     * @return boolean
     */
    boolean addUser(User user);

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 用户
     */
    User queryUserById(long id);

    /**
     * 根据用户ID修改用户
     * @param user 用户
     * @return boolean
     */
    boolean updateUserById(User user);

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return boolean
     */
    boolean deleteUserById(long id);
}
