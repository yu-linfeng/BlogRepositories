package com.coderbuff.sword.s7;

/**
 * Description:
 * 测试程序
 * 中序遍历序列：4,7,2,1,5,3,8,6
 * 前序遍历序列：1,2,4,7,3,5,6,8
 *               1
 *             /  \
 *            2    3
 *           /    / \
 *           4   5   6
 *           \      /
 *            7    8
 * 2019-06-03
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] preOrder = new Integer[]{1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inOrder = new Integer[]{4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        Node<Integer> head = solution.buildBinaryTree(preOrder, inOrder);
    }
}
