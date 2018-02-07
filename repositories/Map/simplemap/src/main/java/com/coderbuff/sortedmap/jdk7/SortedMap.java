package com.coderbuff.sortedmap.jdk7;

import java.util.*;

/**
 * Sort a Map by Keys and Values.
 *
 * Created by Kevin on 2018/2/6.
 */
public class SortedMap {

    /**
     * Sort a Map by Keys.
     * @param map To be sorted Map.
     * @return Sorted Map.
     */
    public Map<String, Integer> sortedByKeys(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            linkedMap.put(entry.getKey(), entry.getValue());
        }

        return linkedMap;
    }

    public Map<String, Integer> sortedByValues(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator =  list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            linkedMap.put(entry.getKey(), entry.getValue());
        }

        return linkedMap;
    }

}
