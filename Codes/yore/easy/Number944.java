package com.yore.easy;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number944 {
    public static void main(String[] args) {
        Number944 number944 = new Number944();
        long startTime = System.currentTimeMillis();
        System.out.println(number944.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int minDeletionSize(String[] A) {
        int count = 0;
        int rowLength = A.length;
        if (rowLength == 1) {
            return 0;
        }
        int colLength = A[0].length();
        for (int col = 0; col < colLength; col++) {
            for (int row = 1; row < rowLength; row++) {
                if (A[row].charAt(col) < A[row - 1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
