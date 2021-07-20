package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/8 8:33
 * @description
 */
public class Offer46 {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            return translateNum(num / 10);
        }
    }

    public static void main(String[] args) {
        Offer46 o = new Offer46();
        System.out.println(o.translateNum(12258));
    }
}
