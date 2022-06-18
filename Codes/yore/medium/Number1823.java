package com.yore.medium;

/**
 * @author Yore
 * @date 2022/5/4 9:39
 * @description
 */
public class Number1823 {
    public static void main(String[] args) {
        Number1823 number1823 = new Number1823();
        System.out.println(number1823.findTheWinner(5, 3));
    }

    public int findTheWinner(int n, int k) {
        int[] visits = new int[n + 1];
        int vis = 0;
        int idx = 0;
        while (vis < n - 1) {
            int count = 0;
            while (count < k) {
                idx++;
                idx = idx > n ? 1 : idx;
                if (visits[idx] == 0) {
                    count++;
                }
            }
            visits[idx] = 1;
            vis += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (visits[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
