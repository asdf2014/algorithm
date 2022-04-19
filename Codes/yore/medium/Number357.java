package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/11 8:48
 * @description
 */
public class Number357 {
    public static void main(String[] args) {
        Number357 number = new Number357();
        System.out.println(number.countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10;
        int last = 9;
        for (int d = 2; d <= n; d++) {
            last = (last * (10 - d + 1));
            res += last;
        }
        return res;
    }
}
