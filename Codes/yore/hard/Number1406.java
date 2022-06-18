package com.yore.hard;

/**
 * @author Yore
 * @date 2022/3/24 9:39
 * @description
 */
public class Number1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] suffixSum = new int[n + 3];
        suffixSum[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1] + stoneValue[i];
        }
        int[] fRecord = new int[n];
        int[] sRecord = new int[n];
        for (int i = 0; i < n; i++) {
            fRecord[i] = -1;
            sRecord[i] = -1;
        }
        int cnt1 = f(stoneValue, n, suffixSum, 0, 0, fRecord, sRecord);
        int cnt2 = s(stoneValue, n, suffixSum, 0, 0, fRecord, sRecord);
        return cnt1 == cnt2 ? "Tie" : cnt1 > cnt2 ? "Alice" : "Bob";
    }

    public int f(int[] stoneValue, int n, int[] suffixSum, int idx, int value, int[] fRecord, int[] sRecord) {
        if (idx >= n) {
            return 0;
        }
        if (idx == n - 1) {
            return stoneValue[n - 1];
        }
        if (fRecord[idx] != -1) {
            return fRecord[idx];
        }
        int count = Integer.MIN_VALUE;
        for (int x = 1; x <= 3; x++) {
            count = Math.max(count, suffixSum[idx] - suffixSum[idx + x] + s(stoneValue, n, suffixSum, idx + x, value, fRecord, sRecord));
        }
        fRecord[idx] = count + value;
        return fRecord[idx];
    }

    public int s(int[] stoneValue, int n, int[] suffixSum, int idx, int value, int[] fRecord, int[] sRecord) {
        if (idx >= n - 1) {
            return 0;
        }
        if (sRecord[idx] != -1) {
            return sRecord[idx];
        }
        int count = Integer.MAX_VALUE;
        for (int x = 1; x <= 3; x++) {
            count = Math.min(count, f(stoneValue, n, suffixSum, idx + x, value, fRecord, sRecord));
        }
        sRecord[idx] = count + value;
        return sRecord[idx];
    }
}
