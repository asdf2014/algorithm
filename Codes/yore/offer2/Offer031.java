package com.yore.offer2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/2/22 10:29
 * @description
 */
public class Offer031 {
    class LRUCache {
        Map<Integer, Integer> linkMap;
        int cap;

        public LRUCache(int capacity) {
            this.linkMap = new LinkedHashMap<>(capacity);
            this.cap = capacity;
        }

        public int get(int key) {
            if (linkMap.containsKey(key)) {
                makeRecent(key);
                return linkMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (linkMap.containsKey(key)) {
                linkMap.put(key, value);
                makeRecent(key);
                return;
            }
            if (linkMap.size() >= cap) {
                linkMap.remove(linkMap.keySet().iterator().next());
            }
            linkMap.put(key, value);
        }

        public void makeRecent(int key) {
            int val = linkMap.get(key);
            linkMap.remove(key);
            linkMap.put(key, val);
        }
    }
}
