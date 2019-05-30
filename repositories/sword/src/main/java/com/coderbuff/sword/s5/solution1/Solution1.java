package com.coderbuff.sword.s5.solution1;

/**
 * Description:
 * 解法一：直接使用JDK提供的方法
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution1 {
    public String replaceSpace(String str) {
        return str.replaceAll(" ", "%20");
    }
}
