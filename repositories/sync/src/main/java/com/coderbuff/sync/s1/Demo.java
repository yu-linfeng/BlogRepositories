package com.coderbuff.sync.s1;

/**
 * Description:
 * 死循环，目的是两个线程抢占一个锁时，只要其中一个线程获取，另一个线程就会一直阻塞
 * 2019-06-13
 * Created with OKevin.
 */
public class Demo {

    public synchronized void demo() {
        while (true) {   //synchronized方法内部是一个死循环，一旦一个线程持有过后就不会释放这个锁
            System.out.println(Thread.currentThread());
        }
    }
}
