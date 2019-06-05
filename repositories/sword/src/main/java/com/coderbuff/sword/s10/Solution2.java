package com.coderbuff.sword.s10;

/**
 * Description:
 * 斐波那契数列，循环实现
 * 2019-06-05
 * Created with OKevin.
 */
public class Solution2 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int result = first + second;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
