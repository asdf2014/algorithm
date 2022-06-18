package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/10 8:26
 * @description
 */
public class Number495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int seconds = 0;
        int last = 0;
        for (int timeSery : timeSeries) {
            if (last != 0 && last + duration >= timeSery) {
                seconds -= (last + duration - timeSery);
            }
            seconds += duration;
            last = timeSery;
        }
        return seconds;
    }
}
