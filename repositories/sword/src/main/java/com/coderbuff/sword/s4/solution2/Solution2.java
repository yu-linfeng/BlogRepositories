package com.coderbuff.sword.s4.solution2;

/**
 * Description:
 * 解法二：因为二维数组每行递增，且每列也是递增的，从二维数组的最右上角开始查找
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution2 {

    public boolean isExist(Integer[][] arrays, Integer target) {
        int x = 0;
        int y = arrays[0].length - 1;

        for (int i = 0; i < arrays.length - 1 + arrays[0].length - 1; i++) {
            if (arrays[x][y].equals(target)) {
                return true;
            }
            if (arrays[x][y] > target) {
                y--;
                continue;
            }
            if (arrays[x][y] < target) {
                x++;
            }
        }

        return false;
    }

}
