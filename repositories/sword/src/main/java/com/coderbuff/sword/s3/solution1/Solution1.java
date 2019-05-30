package com.coderbuff.sword.s3.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * 解法一：利用Map
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution1 {
    public void findRepeat(Integer[] array) {
        Set<Integer> noRepeat = new HashSet<>();
        for (Integer num : array) {
            if (!noRepeat.contains(num)) {
                noRepeat.add(num);
                continue;
            }
            System.out.println("重复的数字：" + num);
        }
    }
}
