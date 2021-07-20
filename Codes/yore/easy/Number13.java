package com.yore.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/5/15 9:04
 * @description
 */
public class Number13 {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                number += 1000;
            } else if (s.charAt(i) == 'D') {
                number += 500;
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    number += 400;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    number += 900;
                    i++;
                } else {
                    number += 100;
                }
            } else if (s.charAt(i) == 'L') {
                number += 50;
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    number += 40;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    number += 90;
                    i++;
                } else {
                    number += 10;
                }
            } else if (s.charAt(i) == 'V') {
                number += 5;
            } else if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    number += 4;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    number += 9;
                    i++;
                } else {
                    number += 1;
                }
            }
        }
        return number;
    }

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt1(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
