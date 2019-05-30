package com.coderbuff.sword.s2.hungry;

/**
 * Description:
 * 饿汉模式单例
 * 2019-05-30
 * Created with OKevin.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
