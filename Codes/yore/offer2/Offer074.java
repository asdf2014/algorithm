package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/11 9:25
 * @description
 */
public class Offer074 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            int size = res.size();
            if (size == 0 || res.get(size - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(size - 1)[1] = Math.max(res.get(size - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
