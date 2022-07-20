package com.yore.easy;

/**
 * @author Yore
 * @date 2022/6/17 9:22
 * @description
 */
public class Number1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;
        int idx = 0;
        while (count < n) {
            if (arr[idx] == 0) {
                count += 2;
            } else {
                count += 1;
            }
            idx++;
        }
        idx--;
        int right = n - 1;
        if (count == n + 1) {
            arr[right--] = 0;
            idx--;
        }
        while (right > 0) {
            if (arr[idx] == 0) {
                arr[right--] = 0;
                arr[right--] = 0;
            } else {
                arr[right--] = arr[idx];
            }
            idx--;
        }
    }
}
