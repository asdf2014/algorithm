package com.yore.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/12 10:04
 * @description
 */
public class Number2111 {
    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            int idx = i;
            while (idx < n) {
                list.add(arr[idx]);
                idx += k;
            }
            res += (list.size() - lit(list));
        }
        return res;
    }

    public int lit(List<Integer> data) {
        int n = data.size();
        int[] d = new int[n];
        int res = 0;
        for (int num : data) {
            int left = 0;
            int right = res;
            while (left < right) {
                int m = left + ((right - left) >> 1);
                if (d[m] <= num) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            d[right] = num;
            if (res == right) {
                res++;
            }
        }
        return res;
    }
}
