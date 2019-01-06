package com.mongo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author OKevin
 * @description: MongoDB实体映射类
 * @date 2019-01-06 12:10
 */
@Data
@ToString
@Document(collection = "user")  //对应MongoDB数据库中的集合
public class User implements Serializable {

    private static final long serialVersionUID = 5094995541812833015L;
    /**
     * 主键使用此注解
     */
    @Id
    private String id;

    /**
     * 字段使用此注解
     */
    @Field
    private String name;
}
