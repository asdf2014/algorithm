//There is an integer array nums sorted in ascending order (with distinct
//values).
//
// Prior to being passed to your function, nums is rotated at an unknown pivot
//index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
// Given the array nums after the rotation and an integer target, return the
//index of target if it is in nums, or -1 if it is not in nums.
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3:
// Input: nums = [1], target = 0
//Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -10⁴ <= nums[i] <= 10⁴
// All values of nums are unique.
// nums is guaranteed to be rotated at some pivot.
// -10⁴ <= target <= 10⁴
//
// Related Topics 数组 二分查找 👍 1546 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 {
		if nums[0] == target {
			return 0
		}
		return -1
	}

	rotateIndex := binarySearchRotateIndex(nums)
	lRes := binarySearch(nums[:rotateIndex], target)
	rRes := binarySearch(nums[rotateIndex:], target)
	if lRes == -1 && rRes == -1 {
		return -1
	}
	if lRes != -1 {
		return lRes
	}
	{
		return rotateIndex + rRes
	}
}

// 二分并找到那个旋转的位置
func binarySearchRotateIndex(nums []int) (index int) {
	mid := len(nums) / 2
	l, r := 0, len(nums)-1
	for l <= r {
		if r-l == 0 {
			return l
		}
		if r-l == 1 {
			if nums[0] > nums[l] {
				return l
			}
			if nums[0] > nums[r] {
				return r
			}
			return 0
		}
		if nums[0] > nums[mid] {
			r = mid
		} else {
			l = mid
		}
		mid = (r + l) / 2
	}
	return
}

// 常规二分
func binarySearch(nums []int, target int) (index int) {
	mid := len(nums) / 2
	l, r := 0, len(nums)-1
	if len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 {
		if nums[0] == target {
			return 0
		}
		return -1
	}
	if target < nums[l] || target > nums[r] {
		return -1
	}
	for l <= r {
		if nums[mid] == target {
			return mid
		}
		if r-l == 0 {
			if target == nums[l] {
				return l
			}
			return -1
		}
		if r-l == 1 {
			if target == nums[l] {
				return l
			}
			if target == nums[r] {
				return r
			}
			return -1
		}
		if target < nums[mid] {
			r = mid
		} else {
			l = mid
		}
		mid = (r + l) / 2
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	//fmt.Println(binarySearchRotateIndex([]int{4, 5, 6, 7, 0, 1, 2}))
	//fmt.Println(binarySearchRotateIndex([]int{1}))
	//fmt.Println(binarySearchRotateIndex([]int{2, 3, 1}))
	//fmt.Println(binarySearchRotateIndex([]int{2, 3, 1, 2}))

	//fmt.Println(binarySearch([]int{0, 1, 2}, 0))
	//fmt.Println(binarySearch([]int{0, 1, 2, 3}, 3))
	//fmt.Println(binarySearch([]int{1}, 3))

	fmt.Println(search([]int{3, 1}, 3))
	fmt.Println(search([]int{1, 3}, 0))
	fmt.Println(search([]int{1, 3}, 1))
	fmt.Println(search([]int{4, 5, 6, 7, 0, 1, 2}, 0))
	fmt.Println(search([]int{4, 5, 6, 7, 0, 1, 2}, 3))
	fmt.Println(search([]int{1}, 3))
}
