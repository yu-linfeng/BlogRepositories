package com.coderbuff.sword.s6;

import com.coderbuff.sword.s6.solution1.Solution1;
import com.coderbuff.sword.s6.solution2.Solution2;

/**
 * Description:
 * 测试程序,1->2->3->4->5
 * 2019-05-31
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node(1);
        Node<Integer> node2 = new Node(2);
        Node<Integer> node3 = new Node(3);
        Node<Integer> node4 = new Node(4);
        Node<Integer> node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node<Integer> head = node1;

        Solution1 solution1 = new Solution1();
        solution1.tailPrint(head);
        Solution2 solution2 = new Solution2();
        solution2.tailPrint(head);
    }
}
