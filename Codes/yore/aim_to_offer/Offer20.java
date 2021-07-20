package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/12 8:11
 * @description
 */
public class Offer20 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean need = false;
        boolean contain = s.contains(".");
        if (s.length() <= 0) {
            return false;
        }
        int index = 0;
        if (contain) {
            //小数
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                index++;
            }
            if (index >= s.length()) {
                return false;
            }
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                need = true;
                index++;
            }
            if (index >= s.length()) {
                return false;
            }
            if (s.charAt(index++) != '.') {
                return false;
            }
            if (!need && index == s.length()) {
                return false;
            }
            if (!need) {
                if (!(s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                    return false;
                }
                index++;
            }
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
        } else {
            //整数
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                index++;
            }
            if (index >= s.length()) {
                return false;
            }
            if (!(s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                return false;
            }
            index++;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
        }
        if (index == s.length()) {
            return true;
        }
        if ((s.charAt(index) == 'e' || s.charAt(index) == 'E') && index > 0) {
            index++;
            if (index == s.length()) {
                return false;
            }
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                index++;
            }
            if (index >= s.length()) {
                return false;
            }
            if (!(s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                return false;
            }
            index++;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
            return index == s.length();
        }
        return false;
    }

    public static void main(String[] args) {
        Offer20 o = new Offer20();
        String s = "+e1";
        System.out.println(o.isNumber(s));
    }
}
