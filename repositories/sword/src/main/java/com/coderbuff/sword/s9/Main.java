package com.coderbuff.sword.s9;

/**
 * Description:
 * 测试程序
 * 2019-06-05
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println(queue.appendTail(1));
        System.out.println(queue.appendTail(2));
        System.out.println(queue.deleteHead());
    }
}
