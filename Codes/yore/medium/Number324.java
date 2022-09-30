package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/6/28 8:54
 * @description
 */
public class Number324 {
    public static void main(String[] args) {
        Number324 number324 = new Number324();
        number324.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int right = n - 1;
        int[] t = new int[n];
        int idx = 0;
        while (idx < n) {
            if (idx % 2 == 0) {
                t[idx++] = nums[left--];
            } else {
                t[idx++] = nums[right--];
            }
        }
        System.arraycopy(t, 0, nums, 0, n);
    }
}
