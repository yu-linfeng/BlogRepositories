package com.coderbuff.sword.s16;

/**
 * Description:
 * 考虑指数为0，负数，整数；数值为0的情况;0^0在数学上没有意义
 * 2019-06-21
 * Created with OKevin.
 */
public class Solution2 {

    public double pow(int m, int n) {
        double result = 0;
        if (m == 0 && n < 0) {
            return -1;
        }
        int absN = Math.abs(n);    //取绝对值
        result = calc(m, absN);
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    private int calc(int m, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return m;
        }
        int result = calc(m, n >> 1);    //右移1位表示除以2
        result *= result;
        if ((m & 1) == 1) {     //位运算判断是会否为奇数，奇数的二进制第一位一定是1与1做与运算即可判断是否为奇数，代替m%2是否等于0
            result *= m;
        }
        return result;
    }
}
