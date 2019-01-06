package com.mongo.dao;

import com.mongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author OKevin
 * @description: 数据层操作类
 * @date 2019-01-06 19:52
 */
@Component
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存用户
     * @param user 返回保存的用户
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据名字查询用户
     * @param name 名字
     * @return 用户
     */
    public List<User> findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    /**
     * 更新用户
     * @param user 待更新的用户
     */
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName());
        mongoTemplate.updateFirst(query, update, User.class);
    }

    /**
     * 根据MongoDB的_id删除用户
     * @param Id _id
     */
    public void deleteUserById(String Id) {
        Query query = new Query(Criteria.where("id").is(Id));
        mongoTemplate.remove(query, User.class);
    }

}
