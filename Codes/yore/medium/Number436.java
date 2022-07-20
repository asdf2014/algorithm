package com.yore.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/5/20 9:47
 * @description
 */
public class Number436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] sortInterval = new int[n][2];
        for(int i=0;i<n;i++){
            System.arraycopy(intervals[i],0,sortInterval[i],0,2);
        }
        Arrays.sort(sortInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        int[] res = new int[n];
        Map<Integer,Integer> idxMap = new HashMap<>();
        Map<Integer,Integer> originalMap = new HashMap<>();
        int index = 0;
        for(int[] it : sortInterval){
            idxMap.put(it[0],index++);
        }
        index =0;
        for(int[] it : intervals){
            originalMap.put(it[0],index++);
        }
        index =0;
        for(int[] it : intervals){
            int begin = it[0];
            int end = it[1];
            int idx = idxMap.get(begin);
            int val = -1;
            while(idx< n){
                if(sortInterval[idx][0] >= end){
                    val = originalMap.get(sortInterval[idx][0]);
                    break;
                }
                idx++;
            }
            res[index++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {2, 4}};


        int n = intervals.length;
        int[][] original = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.arraycopy(intervals[i], 0, original[i], 0, 2);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(intervals[0][0] + " " + intervals[0][1]);
        System.out.println(intervals[1][0] + " " + intervals[1][1]);
        System.out.println(intervals[2][0] + " " + intervals[2][1]);
    }
}
