package com.yore.offer;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/7/12 9:15
 * @description
 */
public class Offer19 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Offer19 o = new Offer19();
        System.out.println(o.isMatch("ab", ".*c"));
        System.out.println(o.isMatch("aaa", "aaaa"));
        System.out.println(o.isMatch("aab", "a*c*b"));
        System.out.println(o.isMatch("ab", ".b"));
        System.out.println(o.isMatch("ab", ".*"));
        System.out.println(o.isMatch("aa", "a*"));
        System.out.println(o.isMatch("aab", "c*a*b"));
        System.out.println(o.isMatch("mississippi", "mis*is*p*."));
    }
}
