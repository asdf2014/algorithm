package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/15 15:38
 * @description
 */
public class Number1716 {

    public static void main(String[] args) {
        Number1716 n = new Number1716();
        System.out.println(n.totalMoney2(26));
    }

    public int totalMoney(int n) {
        int base = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                base += 1;
                sum += base;
            } else {
                sum += (base + i % 7);
            }
        }
        return sum;
    }

    /**
     * 等比数列求和  Sn = n*(a1+an)/2
     *
     * @param n
     * @return
     */
    public int totalMoney2(int n) {
        int quotient = n / 7;
        int remainder = n % 7;
        int sum = 0;
        if (quotient > 0) {
            int first = (1 + 7) * 7 / 2;
            int last = first + (quotient - 1) * 7;
            sum += (first + last) * quotient / 2;
        }
        if (remainder > 0) {
            sum += (quotient + 1 + quotient + remainder) * remainder / 2;
        }
        return sum;
    }
}
