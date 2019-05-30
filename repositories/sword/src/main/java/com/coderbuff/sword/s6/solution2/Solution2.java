package com.coderbuff.sword.s6.solution2;

import com.coderbuff.sword.s6.Node;

/**
 * Description:
 * 解法二：递归
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution2 {

    public void tailPrint(Node<Integer> head) {
        if (head.getNext() != null) {
            tailPrint(head.getNext());
        }
        System.out.println(head.getData());
    }
}
