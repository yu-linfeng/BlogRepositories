package com.coderbuff.sword.s8;

/**
 * Description:
 *          1
 *         / \
 *        2   3
 *       /   / \
 *      4   5  6
 *       \    /
 *        7  8
 * 中序遍历序列：4,7,2,1,5,3,8,6
 * 2019-06-05
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setParent(node1);
        node3.setLeft(node5);
        node3.setRight(node6);
        node3.setParent(node1);
        node4.setRight(node7);
        node4.setParent(node2);
        node5.setParent(node3);
        node6.setLeft(node8);
        node6.setParent(node3);
        node7.setParent(node4);
        node8.setParent(node6);
        Solution solution = new Solution();
        System.out.println(solution.findNextNode(node1).getData());
    }
}
