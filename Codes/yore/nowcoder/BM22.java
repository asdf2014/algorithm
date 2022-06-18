package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/5/9 9:15
 * @description
 */
public class BM22 {
    public int compare(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int L1 = v1.length;
        int L2 = v2.length;
        while (i < L1 || j < L2) {
            if (i >= L1) {
                if (Integer.parseInt(v2[j++]) == 0) {
                    continue;
                }
                return -1;
            }
            if (j >= L2) {
                if (Integer.parseInt(v1[i++]) == 0) {
                    continue;
                }
                return 1;
            }
            int val1 = Integer.parseInt(v1[i++]);
            int val2 = Integer.parseInt(v2[j++]);
            if (val1 != val2) {
                return val1 > val2 ? 1 : -1;
            }
        }
        return 0;
    }
}
