package com.yore.easy;

/**
 * @author Yore
 * @date 2022/2/23 8:31
 * @description
 */
public class Number917 {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i);
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < len && !Character.isLetter(arr[left])) {
                left++;
            }
            while (right >= 0 && !Character.isLetter(arr[right])) {
                right--;
            }
            if (left < right) {
                char c = arr[left];
                arr[left++] = arr[right];
                arr[right--] = c;
            }
        }
        return new String(arr);
    }
}
