package com.coderbuff.sync.s2;

/**
 * Description:
 * 测试synchronized同步代码块对本实例加锁（this）
 * 假设demo1与demo2方法不相关，此时两个线程对同一个对象实例分别调用demo1与demo2，只要其中一个线程获取到了锁即执行了demo1或者demo2，此时另一个线程会永远处于阻塞状态
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
