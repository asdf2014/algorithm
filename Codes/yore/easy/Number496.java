package com.yore.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Yore
 * @date 2021/11/11 8:27
 * @description
 */
public class Number496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len =  nums1.length;
        int[] res = new int[len];
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            indexMap.put(nums2[i],i);
        }
        int j = 0;
        for(int i=0;i<len;i++){
            j = indexMap.get(nums1[i]);
            while(j<nums2.length){
                if(nums2[j]>nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
                j++;
            }
            if(j == nums2.length){
                res[i] = -1;
            }
        }
        return res;
    }

    /**
     * 单调栈思路
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> valueMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            valueMap.put(nums2[i],stack.isEmpty()? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i=0;i<res.length;i++){
            res[i] = valueMap.get(nums1[i]);
        }
        return res;
    }
}
