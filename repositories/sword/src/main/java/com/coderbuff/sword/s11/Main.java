package com.coderbuff.sword.s11;

import java.util.Arrays;

/**
 * @author cdyulinfeng
 * @date 2019/6/3
 **/
public class Main {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(binarySearch.find(array, 8));

        QuickSort quickSort = new QuickSort();
        Integer[] sort = new Integer[]{5, 4, 3, 2, 1};
        quickSort.sort(sort);
        System.out.println(Arrays.toString(sort));
    }
}
