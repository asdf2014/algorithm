package com.yore.easy;

import java.util.Arrays;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number977 {
    public static void main(String[] args) {
        Number977 number977 = new Number977();
        long startTime = System.currentTimeMillis();
        int[] result = number977.sortedSquares(new int[]{-4,-3,-2,0,1,2,3,5,7});
        System.out.println(Arrays.toString(result));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");

    }


    private int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] b = new int[length];
        int i = 0;
        int forward = 0;
        int backward = 0;
        for (; i < length; i++) {
            if (A[i] >= 0) {
                forward = i - 1;
                backward = i;
                break;
            }
        }
        if (i == length) {
            forward = length - 1;
            backward = length;
        }
        int index = 0;
        int data1;
        int data2;
        while (forward >= 0 || backward < length) {
            if (forward < 0) {
                b[index++] = A[backward] * A[backward];
                backward++;
            } else if (backward >= length) {
                b[index++] = A[forward] * A[forward];
                forward--;
            } else {
                data1 = A[forward] * A[forward];
                data2 = A[backward] * A[backward];
                if (data1 >= data2) {
                    b[index++] = data2;
                    backward++;
                } else {
                    b[index++] = data1;
                    forward--;
                }
            }
        }
        return b;
    }
}
