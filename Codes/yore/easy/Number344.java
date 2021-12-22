package com.yore.easy;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number344 {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        for(char c : s){
            System.out.print(c);
        }

    }

    public static void reverseString(char[] s) {
        int length = s.length;
        if (length == 1) {
            return;
        }
        int i = 0;
        int j = length - 1;
        char tmp;
        while (i < j) {
            tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
