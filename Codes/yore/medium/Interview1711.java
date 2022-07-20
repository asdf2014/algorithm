package com.yore.medium;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/27 9:13
 * @description
 */
public class Interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> idxMap = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = idxMap.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            idxMap.put(words[i], list);
        }
        List<Integer> list1 = idxMap.get(word1);
        List<Integer> list2 = idxMap.get(word2);
        Collections.sort(list1);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list2.size(); i++) {
            int index = list2.get(i);
            int left = 0;
            int right = list1.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (list1.get(mid) > index) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (right < 0) {
                right = 0;
            }
            if (left >= list1.size()) {
                left = list1.size() - 1;
            }
            diff = Math.min(diff, Math.min(Math.abs(list1.get(right) - index), Math.abs(list1.get(left) - index)));
        }
        return diff;
    }

    public int findClosest2(String[] words, String word1, String word2) {
        int n = words.length;
        int idx1 = -1;
        int idx2 = -1;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(words[i].equals(word1)){
                idx1 = i;
            }else if(words[i].equals(word2)){
                idx2 = i;
            }
            if(idx1 >= 0 && idx2 >= 0 ){
                diff = Math.min(diff,Math.abs(idx1 - idx2));
            }
        }
        return diff;
    }
}
