package com.manager.user.dao;

import com.manager.user.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理数据操作接口
 * Created by Kevin on 2017/10/24.
 */
@Repository(value = "userDao")
public interface IUserDao {
    /**
     * 查询所有用户
     * @return 用户List
     */
    List<User> queryUsers();

    /**
     * 新增用户
     * @param user 用户
     * @return >0插入成功；=0插入失败
     */
    int addUser(User user);

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 用户
     */
    User queryUserById(long id);

    /**
     * 根据用户ID修改用户
     * @param user 用户
     * @return >0修改成功；=0修改失败
     */
    int updateUserById(User user);

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return >0删除成功；=0删除失败
     */
    int deleteUserById(long id);
}
