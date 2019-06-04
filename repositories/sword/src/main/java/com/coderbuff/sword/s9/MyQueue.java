package com.coderbuff.sword.s9;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * @author OKevin
 * @date 2019/6/3
 **/
public class MyQueue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    /**
     * 从队尾添加元素
     * @param t 元素
     * @return 添加的数据
     */
    public T appendTail(T t) {
        s1.push(t);
        return t;
    }

    /**
     * 对队头删除元素
     * @return 删除的元素
     */
    public T deleteTail() {
        if (s1.empty() && s2.empty()) {
            return null;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        T t = s2.pop();
        return t;
    }
}
