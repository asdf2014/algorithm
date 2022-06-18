package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/23 10:46
 * @description
 */
public class Number859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int[] arr  =new int[26];

        if(s.equals(goal)){
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
                if(arr[s.charAt(i)-'a']>1){
                    return true;
                }
            }
            return false;
        }
        int diff = 0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[goal.charAt(i)-'a']--;
            if(s.charAt(i) != goal.charAt(i)){
                diff++;
            }
        }
        for(int k=0;k<26;k++){
            if(arr[k]!=0){
                return false;
            }
        }
        return diff == 2;
    }
}
