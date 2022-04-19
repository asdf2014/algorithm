package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/12 8:45
 * @description
 */
public class Number806 {
    public int[] numberOfLines(int[] widths, String s) {
        int row = 1;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur + widths[idx] <= 100) {
                cur += widths[idx];
            } else {
                row++;
                cur = widths[idx];
            }
        }
        return new int[]{row, cur};
    }
}
