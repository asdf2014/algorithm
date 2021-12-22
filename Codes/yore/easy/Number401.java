package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/6/21 9:59
 * @description
 */
public class Number401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(i) + Integer.bitCount(m) == turnedOn) {
                    res.add(i + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }
}
