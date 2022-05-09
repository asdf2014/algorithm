package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/5/7 10:16
 * @description
 */
public class BM20 {
    int[] tmp;

    public int InversePairs(int[] array) {
        int n = array.length;
        tmp = new int[n];
        return merge(array, 0, n - 1);
    }

    public int merge(int[] array, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        int res = merge(array, l, mid) + merge(array, mid + 1, r);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = array[k];
        }

        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                array[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                array[k] = tmp[i++];
            } else {
                array[k] = tmp[j++];
                res += (mid - i + 1);
            }
        }
        return res % 1000000007;
    }
}
