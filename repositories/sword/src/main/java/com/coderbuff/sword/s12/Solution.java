package com.coderbuff.sword.s12;

/**
 * 找到旋转数组中的最小值
 * @author OKevin
 * @date 2019/6/3
 **/
public class Solution {

    public Integer find(Integer[] array) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = (left + right) / 2;
            if (array[left].equals(array[right]) && array[left].equals(array[middle])) {
                return min(array, left, right);
            }
            if (array[middle] >= array[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return array[middle];
    }

    /**
     * 当出现原始数组为：{0,1,1,1,1}时，{1,1,1,0,1}和{1,0,1,1,1}均是旋转数组，这两种情况left=middle=right都是1，不能区别
     * @param array 数组
     * @param left 起始
     * @param right 结束
     * @return
     */
    private Integer min(Integer[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i < right; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
