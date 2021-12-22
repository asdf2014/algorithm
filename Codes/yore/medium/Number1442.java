package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/18 8:01
 * @description
 */
public class Number1442 {

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
    }

    public static int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int count = 0;
        int res;
        for (int i = 0; i < arr.length; i++) {
            res = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                res ^= arr[k];
                if (res == 0) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}
