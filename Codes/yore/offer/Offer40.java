package com.yore.offer;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author jia bing wen
 * @date 2021/6/4 8:22
 * @description
 */
public class Offer40 {
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
