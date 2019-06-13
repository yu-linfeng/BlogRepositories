package com.coderbuff.sync.s1;

/**
 * Description:
 * 自定义线程
 * 2019-06-13
 * Created with OKevin.
 */
public class MyThread implements Runnable {
    private Demo demo;

    public MyThread(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.demo();
    }
}
