package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/11/14 14:07
 * @description
 */
public class Number677 {
}
class MapSum {

    Map<String,Integer> map;

    public MapSum() {
        map =new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int sum =0;
        for(String key : map.keySet()){
            if(key.startsWith(prefix)){
                sum += map.get(key);
            }
        }
        return sum;
    }
}
