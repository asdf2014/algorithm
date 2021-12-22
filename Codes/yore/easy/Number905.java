package com.yore.easy;

/**
 * Created on 2019/1/24
 * 按奇偶排序数组
 *
 * @author jiabingwen
 */

public class Number905 {
    public static void main(String[] args) {
        Number905 number905 = new Number905();
        long startTime = System.currentTimeMillis();
        int[] B = number905.sortArrayByParity(new int[]{3, 1, 2, 4});
        for(int num : B){
            System.out.println(num+ " ");
        }
        System.out.println();
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int begin = 0;
        int end = length - 1;
        while (begin < end) {
            int num1 = A[begin];
            if (num1 % 2 == 0) {
                begin++;
            } else if (A[end] % 2 == 1) {
                end--;
            } else {
                A[begin] = A[end];
                A[end] = num1;
                begin++;
                end--;
            }
        }
        return A;
    }
}
