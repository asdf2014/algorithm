package com.yore.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/22 9:48
 * @description
 */
public class Number295 {
    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public Number295() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int len = list.size();
        if (len % 2 == 0) {
            return (list.get(len / 2 - 1) + list.get(len / 2)) / 2.0;
        }
        return list.get(len / 2);
    }
}
