package com.coderbuff.chapter3_stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * 流的创建
 * @author yulinfeng
 * @date 2020/3/16
 */
public class StreamCreator {

    public static void main(String[] args) {

    }

    /**
     * 通过集合构造流
     */
    private void createByCollection() {
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
    }

    /**
     * 通过数组构造流
     */
    private void createByArrays() {
        Integer[] intArrays = {1, 2, 3};
        Stream<Integer> stream = Stream.of(intArrays);
        Stream<Integer> stream1 = Arrays.stream(intArrays);
    }


}
