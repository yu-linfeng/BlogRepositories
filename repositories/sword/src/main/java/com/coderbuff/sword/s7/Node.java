package com.coderbuff.sword.s7;

/**
 * Description:
 * 二叉树节点
 * 2019-06-03
 * Created with OKevin.
 */
public class Node<T> {

    /**
     * 值域
     */
    private T data;

    /**
     * 左节点
     */
    private Node<T> left;

    /**
     * 右节点
     */
    private Node<T> right;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
