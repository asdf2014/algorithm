package com.yore.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/11/7 16:30
 * @description
 */
public class Number710 {

}

class Solution{
    private int boundary;
    private Map<Integer,Integer> map = new HashMap<>();

    public Solution(int n, int[] blacklist) {
        for(int num : blacklist){
            map.put(num,-1);
        }
        boundary = n - blacklist.length;
        int last = n-1;
        for(int number : blacklist){
            if(number >= boundary){
                continue;
            }
            while(map.containsKey(last)){
                last--;
            }
            map.put(number,last);
            last--;
        }
    }

    public int pick() {
        int index = (int) (Math.random() * boundary);
        if(map.containsKey(index)){
            return map.get(index);
        }
        return index;
    }
}
