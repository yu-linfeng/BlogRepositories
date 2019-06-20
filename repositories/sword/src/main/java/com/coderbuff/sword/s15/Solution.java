package com.coderbuff.sword.s15;

/**
 * Description:
 * 移位运算+与运算
 * 2019-06-20
 * Created with OKevin.
 */
public class Solution {
    public int NumberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;    //因为运算>>>表示无符号右移，意味着如果是负数，仍然会向右移，同时用0补齐。如果使用>>有符号右移，那么符号位1永远会存在，也就是会产生死循环
        }
        return count;
    }
}
