package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/13 8:32
 * @description
 */
public class Number520 {
    public boolean detectCapitalUse(String word) {
        int upperCounter = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                upperCounter++;
            }
        }
        if(Character.isUpperCase(word.charAt(0))){
            return upperCounter==1 || upperCounter == word.length();
        }
        return upperCounter ==0;
    }
}
