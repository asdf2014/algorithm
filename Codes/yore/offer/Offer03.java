package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 8:23
 * @description
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] n = new int[nums.length+1];
        for (int current : nums) {
            if(n[current]==0){
                n[current]++;
            }else{
                return current;
            }
        }
        return -1;
    }
}
