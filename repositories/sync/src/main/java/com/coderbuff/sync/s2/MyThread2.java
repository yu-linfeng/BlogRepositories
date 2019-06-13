package com.coderbuff.sync.s2;

/**
 * Description:
 * 自定义线程1
 * 2019-06-13
 * Created with OKevin.
 */
public class MyThread2 implements Runnable {

    private Demo demo;

    public MyThread2(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.demo2();
    }
}
