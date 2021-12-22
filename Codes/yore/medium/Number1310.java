package com.yore.medium;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/5/12 7:46
 * @description
 */
public class Number1310 {

    public int[] xorQueries1(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] result = new int[len];
        int k = 0;
        for (int[] index : queries) {
            if (index[0] == index[1]) {
                result[k] = arr[index[0]];
            } else {
                for (int i = index[0]; i <= index[1]; i++) {
                    result[k] ^= arr[i];
                }
            }
            k++;
        }
        return result;
    }


    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] pre = new int[len + 1];
        Arrays.fill(pre,0);
        for (int i = 1; i < len + 1; i++) {
            pre[i] = arr[i - 1] ^ pre[i - 1];
        }
        int[] result = new int[queries.length];
        int k = 0;
        for (int[] index : queries) {
            result[k++] = pre[index[0]] ^ pre[index[1] + 1];
        }
        return result;
    }
}
