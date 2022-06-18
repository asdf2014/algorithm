package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 9:07
 * @description
 */
public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
