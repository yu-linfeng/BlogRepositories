package com.coderbuff.sync.s3;

/**
 * Description:
 * synchronized同步代码块对对象内部的实例加锁
 * 假设demo1与demo2方法不相关，此时两个线程对同一个对象实例分别调用demo1与demo2，均能获取各自的锁
 * 2019-06-13
 * Created with OKevin.
 */
public class Demo {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void demo1() {
        synchronized (lock1) {
            while (true) {  //死循环目的是为了让线程一直持有该锁
                System.out.println(Thread.currentThread());
            }
        }
    }

    public void demo2() {
        synchronized (lock2) {
            while (true) {
                System.out.println(Thread.currentThread());
            }
        }
    }
}
