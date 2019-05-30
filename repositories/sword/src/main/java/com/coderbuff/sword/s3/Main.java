package com.coderbuff.sword.s3;

import com.coderbuff.sword.s3.solution1.Solution1;
import com.coderbuff.sword.s3.solution2.Solution2;

/**
 * Description:
 * 测试程序
 * 2019-05-31
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Integer[] array = new Integer[]{1, 2, 2, 4, 5, 5};
        solution1.findRepeat(array);
        solution2.findRepeat(array);
    }
}
