package com.coderbuff.sword.s8;

/**
 * Description:
 * 二叉树节点定义
 * 2019-06-05
 * Created with OKevin.
 */
public class Node<T> {
    /**
     * 值域
     */
    private T data;

    /**
     * 左子节点
     */
    private Node<T> left;

    /**
     * 右子节点
     */
    private Node<T> right;

    /**
     * 父节点
     */
    private Node<T> parent;

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

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
