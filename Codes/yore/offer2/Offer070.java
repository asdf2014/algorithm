package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/9 10:22
 * @description
 */
public class Offer070 {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }


    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] == nums[mid^1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
