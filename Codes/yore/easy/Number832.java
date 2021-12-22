package com.yore.easy;

/**
 * Created on 2019/1/24
 * 翻转图像
 *
 * @author jiabingwen
 */

public class Number832 {
    public static void main(String[] args) {
        Number832 number832 = new Number832();
        long startTime = System.currentTimeMillis();
        int[][] result = number832.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
//        int[][] result = number832.flipAndInvertImage(new int[][]{{0}, {1}, { 0}});
        System.out.println("耗时： " + (System.currentTimeMillis() - startTime) + "ms");
        number832.printData(result);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int rowLength = A.length;
        if (rowLength == 0) {
            return null;
        }
        int colLength = A[0].length;
        int begin = 0;
        int end = colLength - 1;
        int tmp = 0;
        for (int i = 0; i < rowLength; i++) {
            while (begin <= end) {
                if (begin == end) {
//                    A[i][begin] = A[i][begin] == 0 ? 1 : 0;
                    A[i][begin] ^= 1;

                    break;
                } else {
                    tmp = A[i][begin];
                    A[i][begin++] = A[i][end] == 0 ? 1 : 0;
                    A[i][end--] = tmp == 0 ? 1 : 0;
                }
            }
            begin = 0;
            end = colLength - 1;
        }
        return A;
    }

    private void printData(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
