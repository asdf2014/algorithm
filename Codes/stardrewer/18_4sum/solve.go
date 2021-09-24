//Given an array nums of n integers, return an array of all the unique
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// You may return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// Example 2:
//
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 双指针 排序 👍 933 👎 0

package main

import (
	"fmt"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)
func fourSum(nums []int, target int) (res [][]int) {
	if len(nums) < 4 {
		return nil // 特解
	}
	sort.Ints(nums)
	fmt.Println(nums)
	var sum int
	for l := 0; l < len(nums); {
		for lm := l + 1; lm < len(nums); {
			for rm, r := lm+1, len(nums)-1; l < lm && lm < rm && rm < r; {
				sum = nums[l] + nums[lm] + nums[rm] + nums[r]
				if sum == target {
					res = append(res, []int{nums[l], nums[lm], nums[rm], nums[r]})
					rm++
					r--
					for rm < r && nums[rm] == nums[rm-1] {
						rm++
					}
					for rm < r && nums[r] == nums[r+1] {
						r--
					}
				} else if sum > target {
					r--
				} else if sum < target {
					rm++
				}
			}
			lm++
			for lm < len(nums) && nums[lm] == nums[lm-1] {
				lm++
			}
		}
		l++
		for l < len(nums) && nums[l] == nums[l-1] {
			l++
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(fourSum([]int{1, -2, -5, -4, -3, 3, 3, 5}, -11))
	fmt.Println(fourSum([]int{1, 0, -1, 0, -2, 2}, 0))
	fmt.Println(fourSum([]int{2, 2, 2, 2, 2}, 8))
}
