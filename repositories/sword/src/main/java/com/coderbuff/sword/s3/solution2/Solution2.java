package com.coderbuff.sword.s3.solution2;

/**
 * Description:
 * 解法二：遍历数组
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution2 {
    public void findRepeat(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    System.out.println("重复的数字：" + array[i]);
                }
            }
        }
    }
}
