package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/25 17:08
 * @description
 */
public class Number680 {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return true;
        }
        int l = 0;
        int r = len-1;
        while(l<r && s.charAt(l) == s.charAt(r)){
            l++;
            r--;
        }
        return isValid(s,l+1,r) | isValid(s,l,r-1);
    }

    public boolean isValid(String s ,int l,int r){
        while(l<r && s.charAt(l) == s.charAt(r)){
            l++;
            r--;
        }
        return l >= r;
    }
}
