package com.yore.offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/28 17:16
 * @description
 */
public class Offer035 {
    private static int VALUE = 24 * 60;

    public static void main(String[] args) {
        Offer035 o = new Offer035();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(o.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE;
        int begin = convert(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int cur = convert(timePoints.get(i));
            diff = Math.min(diff, Math.abs(cur - begin));
            begin = cur;
        }
        int v = convert(timePoints.get(0)) - convert(timePoints.get(timePoints.size() - 1)) + VALUE;
        diff = Math.min(diff, Math.abs(v));
        return diff;
    }

    public int convert(String str) {
        String[] time = str.split(":");
        int hour = Integer.valueOf(time[0]);
        int minute = Integer.valueOf(time[1]);
        return hour * 60 + minute;
    }
}
