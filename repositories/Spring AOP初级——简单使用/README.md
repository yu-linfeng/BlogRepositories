# Spring AOP初级——简单使用
> 博客地址:[http://www.cnblogs.com/yulinfeng/p/7719128.html](http://www.cnblogs.com/yulinfeng/p/7719128.html)

项目结构
```
simapleaop
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── springdemo
    │   │           └── aop
    │   │               ├── security
    │   │               │   ├── CheckUserHolder.java
    │   │               │   └── SecurityAspect.java
    │   │               └── service
    │   │                   ├── AuthService.java
    │   │                   └── ProductService.java
    │   └── resources
    │       └── applicationContext.xml
    └── test
        ├── java
        │   └── com
        │       └── springdemo
        │           └── aop
        │               └── AopTest.java
        └── resources
```
