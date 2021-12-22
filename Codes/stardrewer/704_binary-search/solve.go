//Given an array of integers nums which is sorted in ascending order, and an
//integer target, write a function to search target in nums. If target exists, then
//return its index. Otherwise, return -1.
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
//
//
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//
//
// Example 2:
//
//
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ < nums[i], target < 10⁴
// All the integers in nums are unique.
// nums is sorted in ascending order.
//
// Related Topics 数组 二分查找 👍 373 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func search(nums []int, target int) int {
	l, r := 0, len(nums)-1
	for l <= r {
		mid := (l + r) / 2
		if r-l <= 1 {
			if nums[l] == target {
				return l
			}
			if nums[r] == target {
				return r
			}
			return -1
		}
		if target < nums[mid] {
			r = mid
		} else if target > nums[mid] {
			l = mid
		} else {
			return mid
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(search([]int{-1, 0, 3, 5, 9, 12}, 9))
	fmt.Println(search([]int{-1, 0, 3, 5, 9, 12}, 2))
	fmt.Println(search([]int{2}, 2))
	fmt.Println(search([]int{-1}, -1))
	fmt.Println(search([]int{5}, -1))
}
