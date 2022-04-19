package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/5 16:02
 * @description
 */
public class Number283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return;
        }
        int left =0;
        int right = 0;
        while(right<len){
            if(nums[right]!=0){
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right] = tmp;
            }
            right+=1;
        }
        return ;
    }
}
