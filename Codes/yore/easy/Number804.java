package com.yore.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/1/24
 * 唯一摩尔斯密码词
 *
 * @author jiabingwen
 */

public class Number804 {
    String[] password = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        Number804  number804 = new Number804();
        long startTime = System.currentTimeMillis();
        System.out.println(number804.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");

    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        Map<Character, String> info = new HashMap<>(26);
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            info.put(c, password[i++]);
        }
        for (String word : words) {
            char[] charArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char charStr : charArray){
                sb.append(info.get(charStr));
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
