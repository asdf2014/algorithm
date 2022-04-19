package com.yore.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author jia bing wen
 * @date 2021/6/27 16:38
 * @description
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

}
