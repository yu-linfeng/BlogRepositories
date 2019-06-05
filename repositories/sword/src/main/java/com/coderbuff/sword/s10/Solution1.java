package com.coderbuff.sword.s10;

/**
 * Description:
 * 斐波那契数列，递推实现
 * 2019-06-05
 * Created with OKevin.
 */
public class Solution1 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
