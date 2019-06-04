package com.coderbuff.sword.s7;

/**
 *          1
 *         / \
 *        2   3
 *       /   / \
 *      4   5  6
 *       \    /
 *        7  8
 * @author OKevin
 * @date 2019/5/30
 **/
public class Main {
    public static void main(String[] args) {
        Integer[] preorder = new Integer[]{1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inorder = new Integer[]{4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        Node<Integer> node = solution.buildBinaryTree(preorder, inorder);
    }
}
