package com.coderbuff.sword.s7;

import java.util.Arrays;

/**
 * 根据前序遍历序列和中序遍历序列重建二叉树
 * @author OKevin
 * @date 2019/5/30
 **/
public class Solution {
    public Node<Integer> buildBinaryTree(Integer[] preorder, Integer[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Node<Integer> root = new Node<>(preorder[0]);
        int index = search(0, inorder, root.getData());
        root.setLeft(buildBinaryTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index)));
        root.setRight(buildBinaryTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length)));
        return root;
    }

    /**
     * 在中旬遍历中查询根节点所在的位置
     * @param start 开始查找的下标
     * @param inorder 中序遍历序列
     * @param rootData 根节点值
     * @return 节点值在中序遍历序列中的下标位置
     */
    private int search(int start, Integer[] inorder, Integer rootData) {
        for (; start < inorder.length; start++) {
            if (rootData.equals(inorder[start])) {
                return start;
            }
        }
        return -1;
    }
}
