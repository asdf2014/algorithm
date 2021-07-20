package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/2 8:30
 * @description
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                return numbers[i];
            }
        }
        return min;
    }
}
