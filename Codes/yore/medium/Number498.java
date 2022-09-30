package com.yore.medium;

/**
 * @author Yore
 * @date 2022/6/14 10:07
 * @description
 */
public class Number498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int Ar = 0;
        int Ac = 0;
        int Br = 0;
        int Bc = 0;
        boolean fromUp = false;
        int index = 0;
        while (Ar != m) {
            index = printLevel(mat, Ar, Ac, Br, Bc, fromUp, res, index);
            Ar = Ac == n - 1 ? Ar + 1 : Ar;
            Ac = Ac == n - 1 ? Ac : Ac + 1;
            Bc = Br == m - 1 ? Bc + 1 : Bc;
            Br = Br == m - 1 ? Br : Br + 1;
            fromUp = !fromUp;
        }
        return res;
    }

    public int printLevel(int[][] mat, int Ar, int Ac, int Br, int Bc, boolean fromUp, int[] res, int index) {
        if (fromUp) {
            while (Ar <= Br && Ac >= Bc) {
                res[index++] = mat[Ar++][Ac--];
            }
        } else {
            while (Ar <= Br && Ac >= Bc) {
                res[index++] = mat[Br--][Bc++];
            }
        }
        return index;
    }
}
