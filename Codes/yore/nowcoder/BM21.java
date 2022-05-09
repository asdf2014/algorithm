package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/5/4 10:21
 * @description
 */
public class BM21 {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[right];
    }
}
