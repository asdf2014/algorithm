package com.yore.medium;

import java.util.*;

/**
 * @author Yore
 * @date 2021/11/6 15:37
 * @description
 */
public class Number380 {
}

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer,Integer> indexMap;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        list.add(val);
        indexMap.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int index = indexMap.get(val);
        indexMap.put(list.get(list.size()-1),index);
        list.set(index,list.get(list.size()-1));
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) ((Math.random()*list.size())));
    }
}
