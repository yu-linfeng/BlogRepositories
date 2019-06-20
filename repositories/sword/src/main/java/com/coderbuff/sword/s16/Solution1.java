package com.coderbuff.sword.s16;

/**
 * Description:
 * 循环暴力法
 * 2019-06-20
 * Created with OKevin.
 */
public class Solution1 {
    public int pow(int m, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= m;
        }
        return result;
    }
}
