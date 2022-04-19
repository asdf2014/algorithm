package com.yore.medium;

import java.util.LinkedHashMap;

/**
 * @author Yore
 * @date 2021/12/29 15:02
 * @description
 */
public class Number146_2 {
    class LRUCache {
        private LinkedHashMap<Integer, Integer> linkMap;
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
            if (this.linkMap.containsKey(key)) {
                this.linkMap.put(key, value);
                makeRecent(key);
                return;
            }
            if (this.linkMap.size() >= this.cap) {
                this.linkMap.remove(this.linkMap.keySet().iterator().next());
            }
            this.linkMap.put(key, value);
        }

        public void makeRecent(int key) {
            int val = this.linkMap.get(key);
            this.linkMap.remove(key);
            this.linkMap.put(key, val);
        }
    }
}
