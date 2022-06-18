package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/14 10:05
 * @description
 */
public class Offer096 {

    public static void main(String[] args) {
        Offer096 o = new Offer096();
        System.out.println(o.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n1 && s1.charAt(i) == s3.charAt(i); i++) {
            dp[i + 1][0] = 1;
        }
        for (int j = 0; j < n2 && s2.charAt(j) == s3.charAt(j); j++) {
            dp[0][j + 1] = 1;
        }
        for (int i = 1; i <= n1; i++) {
            char ch1 = s1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = s2.charAt(j - 1);
                char ch3 = s3.charAt(i + j - 1);
                dp[i][j] = (ch3 == ch1 && dp[i - 1][j] == 1) || (ch2 == ch3 && dp[i][j - 1] == 1) ? 1 : 0;
            }
        }
        return dp[n1][n2] == 1;
    }
}
