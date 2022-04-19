package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/29 9:06
 * @description
 */
public class Number2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(process(answerKey, k, 'T'), process(answerKey, k, 'F'));
    }

    public int process(String str, int k, char ch) {
        int n = str.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += ch != str.charAt(right) ? 1 : 0;
            while (sum > k) {
                sum -= ch != str.charAt(left++) ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
