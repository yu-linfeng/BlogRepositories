package com.coderbuff.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * for循环对集合迭代
 * @author okevin
 * @date 2020/3/15 22:54
 */
public class ForDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        ForDemo forDemo = new ForDemo();
        int sum = forDemo.calcSum(list);
        System.out.println(sum);
    }

    public int calcSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
