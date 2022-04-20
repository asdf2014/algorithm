package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/20 9:24
 * @description
 */
public class Number56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        List<int[]> region = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i <= n; i++) {
            while (i < n && intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
                i++;
            }
            region.add(new int[]{begin, end});
            if (i < n) {
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[][] res = new int[region.size()][2];
        for (int i = 0; i < region.size(); i++) {
            res[i] = region.get(i);
        }
        return res;
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> region = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            if (region.size() == 0 || region.get(region.size() - 1)[1] < begin) {
                region.add(new int[]{begin, end});
            } else {
                region.get(region.size() - 1)[1] = Math.max(region.get(region.size() - 1)[1], end);
            }
        }
        return region.toArray(new int[region.size()][]);
    }
}
