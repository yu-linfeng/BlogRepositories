package com.coderbuff.sword.s4.solution1;

/**
 * Description:
 * 解法一：遍历二维数组
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution1 {

    public boolean isExist(Integer[][] arrays, Integer target) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j].equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
