package com.yore.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/6/28 15:30
 * @description
 */
public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        int end = target / 2;
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= end; i++) {
            List<Integer> tmp = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < target; j++) {
                tmp.add(j);
                sum += j;
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    result.add(tmp.stream().mapToInt(Integer::valueOf).toArray());
                    break;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public int[][] findContinuousSequence1(int target) {
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        for (int l = 1, r = 2; l < r; ) {
            sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) {
                r++;
            } else if (sum > target) {
                l++;
            } else {
                int[] tmp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    tmp[i - l] = i;
                }
                result.add(tmp);
                l++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
