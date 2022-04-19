package com.yore.easy;

/**
 * @author Yore
 * @date 2022/3/7 9:21
 * @description
 */
public class Number504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder("");
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            sb.append("-");
            num = Math.abs(num);
        }
        int n = 0;
        while (Math.pow(7, n) <= num) {
            n++;
        }
        n--;
        while (n >= 0) {
            double p = Math.pow(7, n);
            if (num >= p) {
                int v = (int) (num / p);
                sb.append(v);
                num -= v * p;
            } else {
                sb.append("0");
            }
            n--;
        }
        return sb.toString();
    }


    public String convertToBase7_2(int num) {
        StringBuilder sb = new StringBuilder("");
        if (num == 0) {
            return "0";
        }
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
