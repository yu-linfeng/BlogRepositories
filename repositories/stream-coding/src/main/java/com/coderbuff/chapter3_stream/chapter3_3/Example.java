package com.coderbuff.chapter3_stream.chapter3_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream 使用
 * @author okevin
 * @date 2020/3/16
 */
public class Example {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 3);

    }

    /**
     * 通过Stream流过滤元素返回新的集合
     * @param list 待过滤的集合
     * @return 新的集合
     */
    private List<Integer> filterByStream(List<Integer> list) {
        return list.stream()
                .filter(number -> number > 1)
                .collect(Collectors.toList());
    }

    /**
     * 通过for循环过滤元素返回新的集合
     * @param list 待过滤的集合
     * @return 过滤后的集合
     */
    private List<Integer> filterByFor(List<Integer> list) {
        List<Integer> filterList = new ArrayList<>();

        for (Integer number : list) {
            if (number > 1) {
                filterList.add(number);
            }
        }
        return filterList;
    }

}
