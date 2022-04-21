package com.yore.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/4/21 9:38
 * @description
 */
public class Number824 {
    public String toGoatLatin(String sentence) {
        int index = 1;
        String[] words = sentence.split(" ");
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char ch = word.charAt(0);
            if(set.contains(Character.toLowerCase(ch))){
                sb.append(word).append("ma");
            }else{
                sb.append(word.substring(1,word.length())).append(ch).append("ma");
            }
            for(int i=0;i<index;i++){
                sb.append("a");
            }
            sb.append(" ");
            index++;
        }
        return sb.substring(0,sb.length()-1);
    }
}
