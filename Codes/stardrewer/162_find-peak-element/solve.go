//A peak element is an element that is strictly greater than its neighbors.
//
// Given an integer array nums, find a peak element, and return its index. If
//the array contains multiple peaks, return the index to any of the peaks.
//
// You may imagine that nums[-1] = nums[n] = -∞.
//
// You must write an algorithm that runs in O(log n) time.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index
//number 2.
//
// Example 2:
//
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak
//element is 2, or index number 5 where the peak element is 6.
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums[i] != nums[i + 1] for all valid i.
//
// Related Topics 数组 二分查找 👍 560 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func findPeakElement(nums []int) int {
	if len(nums) == 1 {
		return 0
	}
	if len(nums) == 2 {
		if nums[0] > nums[1] {
			return 0
		}
		return 1
	}
	if nums[0] > nums[1] {
		return 0
	}
	if nums[len(nums)-1] > nums[len(nums)-2] {
		return len(nums) - 1
	}
	for i := 1; i < len(nums)-1; i++ {
		if nums[i-1] < nums[i] && nums[i] > nums[i+1] {
			return i
		}
	}
	return 0
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(findPeakElement([]int{1, 2, 3, 1}))
	fmt.Println(findPeakElement([]int{1, 2, 1, 3, 5, 6, 4}))
	fmt.Println(findPeakElement([]int{5, 6, 7, 8}))
}
