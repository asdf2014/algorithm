package com.yore.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/10/8 10:21
 * @description
 */
public class Number187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<=10){
            return new ArrayList<String>();
        }
        Map<String,Integer> hash = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            String subStr = s.substring(i,i+10);
            hash.put(subStr,hash.getOrDefault(subStr,0)+1);
            if(hash.get(subStr)==2){
                result.add(subStr);
            }
        }
        return result;
    }
}
