package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/4/30 9:50
 * @description
 */
public class BM18 {
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int r = m - 1;
        int c = 0;
        while (r >= 0 && c < n) {
            int val = array[r][c];
            if (val == target) {
                return true;
            } else if (val > target) {
                r--;
            } else if (val < target) {
                c++;
            }
        }
        return false;
    }
}
