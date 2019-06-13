package com.coderbuff.sync.s1;

/**
 * Description:
 * 两个线程抢占一个对象实例的锁
 * 2019-06-13
 * Created with OKevin.
 */
public class Main1 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread1 = new Thread(new MyThread(demo));
        Thread thread2 = new Thread(new MyThread(demo));
        thread1.start();
        thread2.start();
    }
}
