package com.coderbuff.sword.s9;

import java.util.Stack;

/**
 * Description:
 * 两个栈实现一个队列
 * 2019-06-05
 * Created with OKevin.
 */
public class MyQueue<T> {
    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();

    public T deleteHead() {
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

    public T appendTail(T t) {
        s1.push(t);
        return t;
    }
}
