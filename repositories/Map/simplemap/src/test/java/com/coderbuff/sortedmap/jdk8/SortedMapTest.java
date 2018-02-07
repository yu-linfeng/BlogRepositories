package com.coderbuff.sortedmap.jdk8;

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
        map.put("z", 10);
        map.put("b", 5);
        map.put("a", 6);
        map.put("c", 20);
        map.put("d", 1);
        map.put("e", 7);
        map.put("y", 8);
        map.put("n", 99);
        map.put("j", 50);
        map.put("m", 2);
        map.put("f", 9);
    }

    @Test
    public void testSortedByKeys() {
        Map<String, Integer> sorted = sortedMap.sortedByKeys(map);
        assertEquals("{a=6, b=5, c=20, d=1, e=7, f=9, j=50, m=2, n=99, y=8, z=10}", sorted.toString());
    }

    @Test
    public void testSortedByValues() {
        Map<String, Integer> sorted = sortedMap.sortedByValues(map);
        assertEquals("{d=1, m=2, b=5, a=6, e=7, y=8, f=9, z=10, c=20, j=50, n=99}", sorted.toString());
    }
}
