package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number28 {
    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public static int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            int point = i;
            if (haystack.charAt(point++) == needle.charAt(j++)) {
                while (j < needleLength && point < haystack.length()) {
                    if (haystack.charAt(point) != needle.charAt(j)) {
                        break;
                    } else {
                        point++;
                        j++;
                    }
                }
                if (j == needleLength) {
                    return i;
                }
            }

        }
        return -1;
    }
}
