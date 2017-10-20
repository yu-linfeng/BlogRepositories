package com.springdemo.aop.security;

import com.springdemo.aop.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private AuthService authService;

    @Pointcut("execution(* com.springdemo.aop.service.ProductService.delete(..))")
    public void adminOnly(){}

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }
}
