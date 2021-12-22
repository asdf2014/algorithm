package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number961 {
    public static void main(String[] args) {
        Number961 number961 = new Number961();
        long startTime = System.currentTimeMillis();
        int result = number961.repeatedNTimes2(new int[]{9,5,6,9});
        System.out.println(result);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>(A.length);
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public int repeatedNTimes2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A[0] == A[A.length - 1]) {
            return A[0];
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                return A[i];
            }
        }
        return -1;
    }
}
