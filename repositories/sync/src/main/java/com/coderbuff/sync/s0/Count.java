package com.coderbuff.sync.s0;

/**
 * Description:
 * 利用5个线程并发执行，num数字累加计数到10000，并打印。
 * 2019-06-13
 * Created with OKevin.
 */
public class Count {
    private int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Thread thread1 = new Thread(count.new MyThread());
        Thread thread2 = new Thread(count.new MyThread());
        Thread thread3 = new Thread(count.new MyThread());
        Thread thread4 = new Thread(count.new MyThread());
        Thread thread5 = new Thread(count.new MyThread());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println(count.num);

    }

    private synchronized void increse() {
        for (int i = 0; i < 2000; i++) {
            num++;
        }
    }

    class MyThread implements Runnable {
        @Override
        public void run() {
            increse();
        }
    }
}
