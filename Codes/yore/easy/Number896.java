package com.yore.easy;

/**
 * @author yore
 * @date 2021/2/28 13:04
 * @description 判断给定数组是否是单调的
 */
public class Number896 {

    public static void main(String[] args) {
        int[] a = {1, 1, 0};
        System.out.println(Number896.isMonotonic(a));

    }

    /**
     * 判断给定数组是否单调递增或递减
     *
     * @param array 数组
     * @return true/false
     */
    public static boolean isMonotonic(int[] array) {
        boolean increase = false;
        int begin = 0;
        int length = array.length;
        if (length <= 2) {
            return true;
        }
        if (array[0] < array[1]) {
            begin = 1;
            increase = true;
        }
        // 考虑出现连续相同的数字的情况
        if (array[0] == array[1]) {
            for (int i = 1; i < length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    begin = i + 1;
                    break;
                }
                if (array[i] < array[i + 1]) {
                    increase = true;
                    begin = i + 1;
                    break;
                }
            }
        }
        for (int i = begin; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                continue;
            }
            if (array[i] < array[i + 1] && !increase) {
                return false;
            } else if (array[i] > array[i + 1] && increase) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonicOfficial(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

}
