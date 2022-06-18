package com.yore.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/1/22 17:31
 * @description
 */
public class Offer093 {
    public static void main(String[] args) {
        Offer093 o = new Offer093();
        System.out.println(o.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
    }

    public int max = 0;
    public Map<Integer, Integer> indexMap = new HashMap<>();

    public int lenLongestFibSubseq(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        int pre;
        int cur;
        int len;
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pre = arr[i];
                cur = arr[j];
                len = 2;
                System.out.print("[" + pre + " " + cur + " ");
                while (indexMap.containsKey(pre + cur)) {
                    tmp = cur;
                    cur = pre + cur;
                    pre = tmp;
                    len++;
                    System.out.print(cur + " ");
                    max = Math.max(max, len);
                }
                System.out.println("]");
            }
        }
        return max;
    }
}
