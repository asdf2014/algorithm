package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Yore
 * @date 2022/3/4 9:33
 * @description
 */
public class Offer058 {
    class MyCalendar {
        List<int[]> list;

        public MyCalendar() {
            this.list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] date : list) {
                if (start < date[1] && end > date[0]) {
                    return false;
                }
            }
            this.list.add(new int[]{start, end});
            return true;
        }
    }

    class MyCalendar2 {
        TreeMap<Integer, Integer> map;

        public MyCalendar2() {
            this.map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> entry1 = this.map.floorEntry(start);
            Map.Entry<Integer, Integer> entry2 = this.map.ceilingEntry(start);
            if (entry1 != null && entry1.getValue() > start) {
                return false;
            }
            if (entry2 != null && entry2.getKey() < end) {
                return false;
            }
            this.map.put(start, end);
            return true;
        }
    }


}
