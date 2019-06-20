package com.coderbuff.sword.s14;

/**
 * Description:
 * 剪绳子——动态规划
 * 2019-06-19
 * Created with OKevin.
 */
public class Solution1 {

    public int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];   //数组中存储的是每段的最优解
        //大于长度3的绳子，当然可以划分出1,2,3长度的绳子
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {  //除以2的原因在上文中也以提到，将一段绳子划分为2段时，实际上中间后的切分和前面是重复的
                int product = products[j] * products[i - j];    //递推关系f(i)*f(n-1)
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }
}
