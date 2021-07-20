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

    public int[] diStringMatch(String S) {
        int[] array = new int[S.length() + 1];
        char[] charArray = S.toCharArray();
        int index = 0;
        int small=0;
        int big = S.length();
        for (char character : charArray) {
            if (character == 'I') {
                array[index++] = small++;
            } else {
                array[index++] =big--;
            }
        }
        array[S.length()] = big;
        return array;
    }
}
