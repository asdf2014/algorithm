package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/11 8:08
 * @description
 */
public class Offer071 {
    class Solution {
        int[] pre;
        int total;

        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            total = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i - 1] + w[i];
                total += w[i];
            }
        }

        public int pickIndex() {
            int rand = (int) (Math.random() * total + 1);
            int l = 0;
            int r = pre.length - 1;
            while (l < r) {
                int mid = (r - l)/2  + l;
                if (rand > pre[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
