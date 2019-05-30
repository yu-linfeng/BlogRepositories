package com.coderbuff.sword.s4;

import com.coderbuff.sword.s4.solution1.Solution1;
import com.coderbuff.sword.s4.solution2.Solution2;

/**
 * Description:
 * 测试程序
 * 2019-05-31
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Integer[][] twoArray = new Integer[4][4];
        twoArray[0] = new Integer[]{1, 2, 8, 9};
        twoArray[1] = new Integer[]{2, 4, 9, 12};
        twoArray[2] = new Integer[]{4, 7, 10, 13};
        twoArray[3] = new Integer[]{6, 8, 11, 15};

        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution1.isExist(twoArray, 7));
        System.out.println(solution2.isExist(twoArray, 7));
    }
}
