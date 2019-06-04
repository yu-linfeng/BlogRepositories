package com.coderbuff.sword.s11;

/**
 * 快速排序
 * @author OKevin
 * @date 2019/6/3
 **/
public class QuickSort {
    public void sort(Integer[] array) {
        partition(array, 0, array.length - 1);
    }

    private void partition(Integer[] array, Integer start, Integer end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        partition(array, start, low - 1);
        partition(array, low + 1, end);
    }
}
