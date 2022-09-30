package com.yore.easy;

import java.util.Arrays;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number942 {
    public static void main(String[] args) {
        Number942 number942 = new Number942();
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(number942.diStringMatch("I")));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int min = 0;
        int max = n;
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        res[n] = max;
        return res;
    }
}
