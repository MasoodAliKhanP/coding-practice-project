package com.google.code._0_Concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SortInt implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

}

public class ComparatorTest {
//    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        List<Integer> intList = Arrays.asList(4, 9, 1, 2, 0);
        List<String> strList = Arrays.asList("a", "z", "n");
        Collections.sort(intList);

        System.out.println(intList);

//        Comparator<Integer> = new ComparatorTest()
        Collections.sort(intList, new SortInt());

        System.out.println(intList);

        Collections.sort(intList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });
        System.out.println(intList);

        Map<String, Integer> hm = new HashMap<>();
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
    }
}
