package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/22 9:48
 * @description
 */
public class Offer041 {
    class MovingAverage {
        List<Integer> list;
        int size;
        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.list = new ArrayList<>(size);
            this.size = size;
        }

        public double next(int val) {
            list.add(val);
            int idx = Math.max(list.size() - this.size, 0);
            double sum = 0.0;
            for(int i=idx;i<list.size();i++){
                sum += list.get(i);
            }
            return sum/size;
        }
    }
}
