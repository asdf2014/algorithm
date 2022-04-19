package com.yore.offer2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/1/22 14:48
 * @description
 */
public class Offer030 {

    class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> indexMap;
        SecureRandom random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            indexMap = new HashMap<>();
            random = new SecureRandom();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (indexMap.containsKey(val)) {
                return false;
            }
            indexMap.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (indexMap.containsKey(val)) {
                int idx = indexMap.get(val);
                int last = list.get(list.size() - 1);
                list.set(idx, last);
                list.remove(list.size() - 1);
                indexMap.put(last, idx);
                indexMap.remove(val);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
