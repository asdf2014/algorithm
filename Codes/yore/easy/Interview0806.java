package com.yore.easy;

import java.util.List;

/**
 * @author Yore
 * @date 2022/6/7 8:55
 * @description
 */
public class Interview0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n < 1) {
            return;
        }
        hanota(n - 1, A, C, B);
        C.add(0, A.remove(0));
        hanota(n - 1, B, A, C);
    }
}
