package com.yore.medium;

import java.util.Stack;

/**
 * @author Yore
 * @date 2021/11/11 9:21
 * @description
 */
public class Number503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        for(int i=2*len-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%len]){
                stack.pop();
            }
            res[i%len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%len]);
        }
        return res;
    }
}
