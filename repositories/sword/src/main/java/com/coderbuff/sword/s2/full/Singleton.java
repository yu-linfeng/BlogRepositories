package com.coderbuff.sword.s2.full;

/**
 * Description:
 * 饱汉模式单例
 * 2019-05-30
 * Created with OKevin.
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
