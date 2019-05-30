package com.coderbuff.sword.s6;

/**
 * Description:
 * 链表节点
 * 2019-05-31
 * Created with OKevin.
 */
public class Node<T> {

    /**
     * 节点值域
     */
    private T data;

    /**
     * 指向的下一个节点
     */
    private Node<T> next;

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

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
