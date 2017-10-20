package com.springdemo.aop.security;

public class CheckUserHolder {
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static String get() {
        return holder.get() == null ? "unknow" : holder.get();
    }

    public static void set(String user) {
        holder.set(user);
    }
}
