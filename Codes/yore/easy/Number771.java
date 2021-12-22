package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/1/24
 * 宝石和石头
 *
 * @author jiabingwen
 */

public class Number771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int length = J.length();
        Set<Character> keySet = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            keySet.add(J.charAt(i));
        }
        int len = S.length();
        for (int j = 0; j < len; j++) {
            if (keySet.contains(S.charAt(j))) {
                count++;
            }
        }
        return count;
    }


    public int numJewelsInStones2(String J, String S) {
        char[] targetArray = J.toCharArray();
        char[] sourceArray = S.toCharArray();
        int count = 0;
        for (char sourceChar : sourceArray) {
            for (char targetChar : targetArray) {
                if (sourceChar == targetChar) {
                    count++;
                }
            }
        }
        return count;
    }
}
