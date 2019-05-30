package com.coderbuff.sword.s6.solution1;

import com.coderbuff.sword.s6.Node;

import java.util.Stack;

/**
 * Description:
 * 解法一：利用JDK中的栈
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution1 {
    public void tailPrint(Node<Integer> head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getData());
        }
    }
}
