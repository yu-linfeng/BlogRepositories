package com.coderbuff.sword.s5.solution2;

/**
 * Description:
 * 解法二：字符串拼接
 * 2019-05-31
 * Created with OKevin.
 */
public class Solution2 {
    public String replaceSpace(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
