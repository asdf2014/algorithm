package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/6 19:36
 * @description
 */
public class Offer069 {
    public int peakIndexInMountainArray(int[] arr) {
        int max = -1;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int right = arr.length - 1;
        int left = 0;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
