package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/6/5 10:55
 * @description
 */
public class Number268 {

    public static int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 巧妙解法 利用位运算
     * @param nums
     * @return
     */
    public int missingNumberBit(int[] nums) {
        int number = 0;
        int n = nums.length;
        for (int num : nums) {
            number ^= num;
        }
        for(int i=0;i<=n;i++){
            number ^= i;
        }
        return number;
    }

    /**
     * 数学公式
     * @param nums
     * @return
     */
    public int missingNumberMath(int[] nums) {
        int sum =0;
        for(int num : nums){
            sum+=num;
        }
        int n = nums.length;
        int totalSum = n*(n+1)/2;
        return totalSum-sum;
    }
}
