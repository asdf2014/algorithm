package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/11/8 16:02
 * @description
 */
public class Number299 {
    public String getHint(String secret, String guess) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for (char c : secret.toCharArray()) {
            countMap.put((int) c, countMap.getOrDefault((int) c, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                bulls++;
                countMap.put((int) c, countMap.get((int) c) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
            } else if (countMap.containsKey((int) c) && countMap.get((int) c) > 0) {
                cows++;
                countMap.put((int) c, countMap.get((int) c) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }

    public String getHint1(String secret, String guess) {
        int[] arr = new int[10];
        int bolls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int c = (int) secret.charAt(i);
            if (secret.charAt(i) == guess.charAt(i)) {
                bolls++;
            }else {
                if (arr[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (arr[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bolls + "A" + cows + "B";
    }
}
