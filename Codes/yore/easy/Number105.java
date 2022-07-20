package com.yore.easy;

/**
 * @author Yore
 * @date 2022/6/13 8:35
 * @description
 */
public class Number105 {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < 101; i++) {
            while (count[i]-- > 0) {
                if (heights[idx++] != i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
