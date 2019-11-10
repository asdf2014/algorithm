package org.ginryan.github.leetcodes.s1_two_sum;

import java.util.ArrayList;

/**
 * 1. 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * @author GinRyan
 *
 */
class Solution {

	public int[] twoSum(int[] nums, int target) {
		ArrayList<Integer> cache = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int diff = target - num;
			if (cache.contains(diff)) {
				return new int[] { cache.indexOf(diff), i };
			}
			cache.add(num);
		}
		return nums;
	}

	public static void main(String[] args) {

	}
}