package com.coderbuff.sortedmap.jdk8;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Kevin on 2018/2/6.
 */
public class SortedMap {

    /**
     * Sort a Map by Keys.
     * @param map To be sorted Map.
     * @return Sorted Map.
     */
    public Map<String, Integer> sortedByKeys(Map<String, Integer> map) {
        System.out.println(map);
        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }

    public Map<String, Integer> sortedByValues(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
}
