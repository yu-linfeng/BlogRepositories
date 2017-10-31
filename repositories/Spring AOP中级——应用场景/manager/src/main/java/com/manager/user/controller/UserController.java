package com.manager.user.controller;

import com.manager.user.pojo.User;
import com.manager.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理示例
 * Created by Kevin on 2017/10/24.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     * @return 用户List
     */
    @GetMapping(value = "/users")
    public List<User> queryUsers(){
        return userService.queryUsers();
    }

    /**
     * 增加用户
     * @return 用户
     */
    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user) ? user : new User();
    }

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping(value = "/users/{id}")
    public User queryUserById(@PathVariable("id") long id) {
        return userService.queryUserById(id);
    }

    /**
     * 更新用户
     * @param id 用户ID
     * @param user 用户其他参数
     */
    @PutMapping(value = "/users/{id}")
    public void updateUserById(@PathVariable("id") long id, @RequestBody User user) {
        user.setId(id);
        userService.updateUserById(user);
    }

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     */
    @DeleteMapping(value = "/users/{id}")
    public void deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
    }
}
