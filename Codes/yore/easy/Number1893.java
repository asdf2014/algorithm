package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/7/23 9:41
 * @description
 */
public class Number1893 {

    /**
     * 暴力解法
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] contain = new int[51];
        for (int[] range : ranges) {
            for (int j = range[0]; j <= range[1]; j++) {
                contain[j] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (contain[i] == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 差分数组 前缀和
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered1(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        int cur = 0;
        for (int i = 0; i < 52; i++) {
            cur += diff[i];
            if (i >= left && i <= right && cur <= 0) {
                return false;
            }
            if (i > right) {
                return true;
            }
        }
        return true;
    }
}
