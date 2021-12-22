package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/5/7 8:18
 * @description
 */
public class Number1486 {
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }
}
