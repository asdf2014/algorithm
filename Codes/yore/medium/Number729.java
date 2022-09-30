package com.yore.medium;

import java.util.TreeMap;

/**
 * @author Yore
 * @date 2022/7/5 8:48
 * @description
 */
public class Number729 {
    public static void main(String[] args) {
        Number729 n = new Number729();
        System.out.println(n.book(10, 20));
        System.out.println(n.book(15, 25));
        ;
        System.out.println(n.book(20, 30));
        ;

    }

    TreeMap<Integer, Integer> timeMap;

    public Number729() {
        this.timeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(timeMap.containsKey(start)){
            return false;
        }
        Integer key = timeMap.lowerKey(start);
        if (key != null) {
            if (start < timeMap.get(key)) {
                return false;
            }
        }
        Integer val = timeMap.higherKey(start);
        if (val != null) {
            if (end <= val) {
                timeMap.put(start, end);
                return true;
            }
            return false;
        }
        timeMap.put(start, end);
        return true;
    }
}
