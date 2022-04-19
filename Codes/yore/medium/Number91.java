package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/27 9:21
 * @description
 */
public class Number91 {
    public static void main(String[] args) {
        Number91 n = new Number91();
        System.out.println(n.numDecodings("10"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int pre = 1;
        int ppre = 0;
        int cur = 0;
        for (int i = 1; i <= n; i++) {
            cur = 0;
            int a = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
            if (a != 0) {
                cur += pre;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                cur += ppre;
            }
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}
