package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/5/6 15:43
 * @description
 */
public class Number1720 {


    public static int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decode[i + 1] = encoded[i] ^ decode[i];
        }
        return decode;
    }
}
