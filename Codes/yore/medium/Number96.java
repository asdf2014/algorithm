package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/25 7:54
 * @description
 */
public class Number96 {
    int[][] mem;

    public int numTrees(int n) {
        mem = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int left, int right) {
        if (left > right) {
            return 1;
        }
        if (mem[left][right] != 0) {
            return mem[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int l = count(left, i - 1);
            int r = count(i + 1, right);
            res += l * r;
        }
        mem[left][right] = res;
        return res;
    }
}
