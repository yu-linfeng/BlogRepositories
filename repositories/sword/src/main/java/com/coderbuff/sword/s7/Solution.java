package com.coderbuff.sword.s7;

import java.util.Arrays;

/**
 * Description:
 * 根据中序遍历序列和前序遍历序列，重建二叉树
 * 前序遍历的序列第一位一定是根节点；中序遍历的根节点左边一定是其左子树节点，右边一定是其右子树节点
 * 2019-06-03
 * Created with OKevin.
 */
public class Solution {

    public Node<Integer> buildBinaryTree(Integer[] preOrder, Integer[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        Node<Integer> root = new Node<>(preOrder[0]);
        int inOrderIndex = search(inOrder, root.getData());
        if (inOrderIndex == -1) {
            return null;
        }
        //定位根节点在中序遍历的位置n后，在中序遍历中n左边即为左子树，n右边即为右子树；在前序遍历中，前n个树即为左子树，后n个即为右子树
        root.setLeft(buildBinaryTree(Arrays.copyOfRange(preOrder, 1, inOrderIndex + 1), Arrays.copyOfRange(inOrder, 0, inOrderIndex)));
        root.setRight(buildBinaryTree(Arrays.copyOfRange(preOrder, inOrderIndex + 1, preOrder.length), Arrays.copyOfRange(inOrder, inOrderIndex + 1, inOrder.length)));
        return root;
    }

    private int search(Integer[] inOrder, Integer data) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
}
