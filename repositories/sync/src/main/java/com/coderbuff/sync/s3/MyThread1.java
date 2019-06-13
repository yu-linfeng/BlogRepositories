package com.coderbuff.sync.s3;

/**
 * Description:
 * 自定义线程1
 * 2019-06-13
 * Created with OKevin.
 */
public class MyThread1 implements Runnable{
    private Demo demo;

    public MyThread1(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.demo1();
    }
}
