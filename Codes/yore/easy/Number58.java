package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("HelloWorld"));
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] array = s.split(" ");
        int length = array.length;
        if (length > 0) {
            String str = array[length - 1];
            return str.length();
        }
        return 0;
    }
}
