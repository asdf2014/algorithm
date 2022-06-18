package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/1/21 16:04
 * @description
 */
public class Offer089 {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    public int rob1(int[] nums){
        int pre=0;
        int cur=0;
        int tmp;
        for(int num : nums){
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }


}
