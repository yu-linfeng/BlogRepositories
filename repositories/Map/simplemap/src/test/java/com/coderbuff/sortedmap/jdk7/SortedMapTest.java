package com.coderbuff.sortedmap.jdk7;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kevin on 2018/2/6.
 */
public class SortedMapTest {
    SortedMap sortedMap;
    Map<String, Integer> map;

    @Before
    public void setUp() {
        sortedMap = new SortedMap();
        map = new HashMap<>();
        map.put("b", 2);
        map.put("a", 3);
        map.put("c", 1);
        map.put("d", 10);
        map.put("f", 11);
        map.put("h", 19);
        map.put("e", 20);
    }

    @Test
    public void testSortedByKeys() {
        Map<String, Integer> sorted = sortedMap.sortedByKeys(map);
        assertEquals("{a=3, b=2, c=1, d=10, e=20, f=11, h=19}", sorted.toString());
    }

    @Test
    public void testSortedByValues() {
        Map<String, Integer> sorted = sortedMap.sortedByValues(map);
        assertEquals("{c=1, b=2, a=3, d=10, f=11, h=19, e=20}", sorted.toString());
    }
}
