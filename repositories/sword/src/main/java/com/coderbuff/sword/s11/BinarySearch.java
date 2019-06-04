package com.coderbuff.sword.s11;

/**
 * 二分查找有序数组中的数字
 * @author OKevin
 * @date 2019/6/3
 **/
public class BinarySearch {

    public boolean find(Integer[] array, Integer target) {
        Integer start = 0;
        Integer end = array.length - 1;
        return partition(array, start, end, target);
    }

    private boolean partition(Integer[] array, Integer start, Integer end, Integer target) {
        if (target < array[start] || target > array[end] || start > end) {
            return false;
        }

        int middle = (end + start) / 2;

        if (target > array[middle]) {
            return partition(array, middle + 1, end, target);
        } else if (target < array[middle]) {
            return partition(array, start, middle - 1, target);
        } else {
            return true;
        }
    }
}
