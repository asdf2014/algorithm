package com.yore.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/1 16:00
 * @description
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
