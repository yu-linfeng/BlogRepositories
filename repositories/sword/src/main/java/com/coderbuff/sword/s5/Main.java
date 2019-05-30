package com.coderbuff.sword.s5;

import com.coderbuff.sword.s5.solution1.Solution1;
import com.coderbuff.sword.s5.solution2.Solution2;

/**
 * Description:
 * 测试程序
 * 2019-05-31
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        String str = "hello world";
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution1.replaceSpace(str));
        System.out.println(solution2.replaceSpace(str));
    }
}
