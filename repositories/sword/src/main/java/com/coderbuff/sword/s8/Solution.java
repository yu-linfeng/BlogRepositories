package com.coderbuff.sword.s8;

/**
 * Description:
 * 查找二叉树的下一个节点
 * 2019-06-05
 * Created with OKevin.
 */
public class Solution {
    public Node<Integer> findNextNode(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        Node<Integer> p = head;
        if (p.getRight() != null) {
            p = head.getRight();
            while (p.getLeft() != null) {
                p = p.getLeft();
            }
            return p;
        }
        while (p.getParent() != null) {
            if (p == p.getParent().getLeft()) {
                return p.getParent();
            }
            p = p.getParent();
        }

        return null;
    }
}
