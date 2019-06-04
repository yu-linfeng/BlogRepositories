package com.coderbuff.sword.s10;

import com.coderbuff.sword.s10.solution1.Solution1;
import com.coderbuff.sword.s10.solution2.Solution2;

/**
 * 0,1,1,2,3,5
 * @author OKevin
 * @date 2019/6/3
 **/
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution1.fibonacci(10));
        System.out.println(solution2.fibonacci(10));
    }
}
