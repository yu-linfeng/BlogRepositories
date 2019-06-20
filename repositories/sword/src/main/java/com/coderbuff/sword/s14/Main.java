package com.coderbuff.sword.s14;

/**
 * Description:
 * 一段长度为n的绳子，请把绳子剪成n段（m、n都是整数，n>1且m>1），每段绳子的长度为k[0]、k[1]、……、k[m]。
 * 请问k[0]*k[1]*……*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2，3,3的三段，此时的最大乘积是18。
 * 2019-06-19
 * Created with OKevin.
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution1.maxProductAfterCutting(10));
        System.out.println(solution2.maxProductAfterCutting(10));
    }
}
