package com.yore.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/18 9:19
 * @description
 */
public class Number539 {
    public static void main(String[] args) {
        Number539 n = new Number539();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("01:39");
        timePoints.add("10:26");
        timePoints.add("21:43");
        System.out.println(n.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        String first = timePoints.get(0);
        int firstTime = 60 * Integer.parseInt(first.split(":")[0]) + Integer.parseInt(first.split(":")[1]);
        String last = timePoints.get(timePoints.size() - 1);
        int lastTime = 60 * Integer.parseInt(last.split(":")[0]) + Integer.parseInt(last.split(":")[1]);
        int minDiff = Math.min(Math.abs(lastTime - firstTime), Math.abs(lastTime - firstTime - 1440));
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int t1 = convertDec(timePoints.get(i));
            int t2 = convertDec(timePoints.get(i + 1));
            minDiff = Math.min(Math.abs(t2 - t1), minDiff);
        }
        return minDiff;
    }

    public int convertDec(String a) {
        String[] t = a.split(":");
        return 60 * Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
    }
}
