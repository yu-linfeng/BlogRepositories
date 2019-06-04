package com.coderbuff.sword.s8;

/**
 * 中序遍历情况下，查找节点的下一个节点
 * @author OKevin
 * @date 2019/6/3
 **/
public class Solution {
    public Node getNextNode(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        Node<Integer> p = head;
        //第一种情况，节点有右子树。节点右子树的最左子节点即为节点中序遍历的下一个节点
        if (p.getRight() != null) {
            p = p.getRight();
            while (p.getLeft() != null) {
                p = p.getLeft();
            }
            return p;
        }
        //第二种情况，节点没有右子树。仍然有两种情况：一、节点位于父节点的左节点，此时父节点即为节点中序遍历的下一个节点；二、节点位于父节点的右节点，此时一直向上查找，直到是它父节点的左节点
        while (p.getParent() != null) {
            if (p == p.getParent().getLeft()) {
                return p.getParent();
            }
            p = p.getParent();
        }
        return null;
    }
}
