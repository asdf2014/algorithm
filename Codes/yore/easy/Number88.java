package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/6/22 9:12
 * @description
 */
public class Number88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor = nums1.length - 1;
        while (n > 0) {
            if (m < 1 || nums1[m - 1] <= nums2[n - 1]) {
                nums1[cursor--] = nums2[n - 1];
                n--;
            } else {
                nums1[cursor--] = nums1[m - 1];
                m--;
            }
        }
    }
}
