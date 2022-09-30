package com.yore.medium;

/**
 * @author Yore
 * @date 2022/7/20 10:28
 * @description
 */
public class Number912 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(nums, L, mid);
        mergeSort(nums, mid + 1, R);
        merge(nums, L, mid, R);
    }

    public void merge(int[] nums, int L, int mid, int R) {
        int[] helper = new int[R - L + 1];
        int p = L;
        int q = mid + 1;
        int index = 0;
        while (p <= mid && q <= R) {
            helper[index++] = nums[p] <= nums[q] ? nums[p++] : nums[q++];
        }
        while (p <= mid) {
            helper[index++] = nums[p++];
        }
        while (q <= R) {
            helper[index++] = nums[q++];
        }
        for (int i = 0; i < helper.length; i++) {
            nums[L + i] = helper[i];
        }
    }
}
