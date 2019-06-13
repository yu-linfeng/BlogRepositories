package com.coderbuff.sync.s1;

/**
 * Description:
 * 两个线程分别抢占两个对象实例的锁
 * 2019-06-13
 * Created with OKevin.
 */
public class Main2 {
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        Thread thread1 = new Thread(new MyThread(demo1));
        Thread thread2 = new Thread(new MyThread(demo2));
        thread1.start();
        thread2.start();
    }
}
