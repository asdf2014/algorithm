package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/25 17:13
 * @description
 */
public class Offer032 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length() || s.equals(t)){
            return false;
        }
        int[] val = new int[26];
        for(int i=0;i<s.length();i++){
            val[s.charAt(i)-'a']++;
            val[t.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26 ;i++){
            if(val[i] != 0){
                return false;
            }
        }
        return true;
    }
}
