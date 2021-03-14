package com.leetcode;
public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        int[] retArr = new int[2];
        for(int i = 0;i <nums.length - 1; i++) {
            for(int j = i + 1;j < nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    retArr[0] = i;
                    retArr[1] = j;
                    return retArr;
                }
            }
        }
        return retArr;
    }
}