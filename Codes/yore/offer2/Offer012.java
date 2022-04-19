package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/10 8:58
 * @description
 */
public class Offer012 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum +=num;
        }
        int left = 0;
        int right = sum;
        for(int i=0;i<nums.length;i++){
            if(left == right - nums[i]){
                return i;
            }
            left += nums[i];
            right -=nums[i];
        }
        return -1;
    }
}
