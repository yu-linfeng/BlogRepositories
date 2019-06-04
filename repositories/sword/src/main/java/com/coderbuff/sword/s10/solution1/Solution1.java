package com.coderbuff.sword.s10.solution1;

/**
 * 求斐波那契数列的第n项
 * @author OKevin
 * @date 2019/6/3
 **/
public class Solution1 {

    public Integer fibonacci(Integer n) {
        if (n.equals(0)) {
            return 0;
        }
        if (n.equals(1)) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
