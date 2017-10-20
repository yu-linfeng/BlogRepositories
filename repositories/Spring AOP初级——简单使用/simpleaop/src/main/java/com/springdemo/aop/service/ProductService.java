package com.springdemo.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public void delete(long id) {
        System.out.println("delete product");
    }
}
