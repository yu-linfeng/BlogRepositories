package com.coderbuff.sword.s9;

/**
 * 测试程序
 * @author OKevin
 * @date 2019/6/3
 **/
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteTail());
    }
}
