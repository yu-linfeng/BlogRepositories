package com.coderbuff.sync.s3;

/**
 * Description:
 * synchronized同步代码块对对象内部的实例加锁
 * 假设demo1与demo2方法不相关，此时两个线程对同一个对象实例分别调用demo1与demo2，均能获取各自的锁
 * 2019-06-13
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread1 = new Thread(new MyThread1(demo));
        Thread thread2 = new Thread(new MyThread2(demo));
        thread1.start();
        thread2.start();
    }
}
