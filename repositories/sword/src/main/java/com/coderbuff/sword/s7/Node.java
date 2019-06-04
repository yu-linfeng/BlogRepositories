package com.coderbuff.sword.s7;

/**
 * 二叉树节点
 * @author OKevin
 * @date 2019/5/30
 **/
public class Node<T> {
    /**
     * 左孩子
     */
    private Node left;

    /**
     * 右孩子
     */
    private Node right;

    /**
     * 值域
     */
    private T data;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
