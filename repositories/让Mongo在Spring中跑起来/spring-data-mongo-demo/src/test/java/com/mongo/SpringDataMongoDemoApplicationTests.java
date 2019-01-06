package com.mongo;

import com.mongo.dao.UserDao;
import com.mongo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataMongoDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("test");
        userDao.saveUser(user);
    }

    @Test
    public void testFindUserByName() {
        String name = "test";
        List<User> users = userDao.findUserByName(name);
        System.out.println(users);
    }

    @Test
    public void testUpdateUser() {
        String id = "5c31f93f91ffb269a774b860";
        User user = new User();
        user.setId(id);
        user.setName("test2");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        String id = "5c31f93f91ffb269a774b860";
        userDao.deleteUserById(id);
    }
}

