package com.yore.medium;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Yore
 * @date 2021/11/22 18:32
 * @description
 */
public class Number384 {

    class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            int[] res = new int[this.nums.length];
            System.arraycopy(this.nums,0,res,0,this.nums.length);
            SecureRandom random = new SecureRandom();
            for(int i=0;i<this.nums.length;i++){
                int j = i+ random.nextInt(nums.length-i);
                int temp = res[i];
                res[i] = res[j];
                res[j] = temp;
            }
            return res;
        }
    }
}
