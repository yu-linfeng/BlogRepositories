package com.coderbuff.sword.s10.solution2;

/**
 * 求斐波那契数列的第n项
 * @author OKevin
 * @date 2019/6/3
 **/
public class Solution2 {

    public Integer fibonacci(Integer n) {
        if (n.equals(0)) {
            return 0;
        }
        if (n.equals(1)) {
            return 1;
        }
        Integer first = 0;
        Integer second = 1;
        Integer result = first + second;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
