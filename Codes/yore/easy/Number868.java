package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/24 9:04
 * @description
 */
public class Number868 {
    public int binaryGap(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int res = 0;
        int tmp = 1;
        int i = 0;
        while (i < binaryStr.length() && binaryStr.charAt(i) == '0') {
            i++;
        }
        i++;
        for (; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '0') {
                tmp++;
            } else {
                res = Math.max(res, tmp);
                tmp = 1;
            }
        }
        return res;
    }


    public int binaryGap_1(int n) {
        int last = -1;
        int ans = 0;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }
}
