//English description is not available for the problem. Please switch to
//Chinese. Related Topics 数组 二分查找 👍 203 👎 0

// 统计一个数字在排序数组中出现的次数。
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2

//示例2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0

//提示：
//0 <= nums.length <= 105
//-109<= nums[i]<= 109
//nums是一个非递减数组
//-109<= target<= 109

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
func search(nums []int, target int) (res int) {
	index := binSearch(nums, target)
	if index == -1 {
		return 0
	}
	for i := index - 1; i >= 0; i-- {
		if nums[i] != target {
			break
		}
		res++
	}
	for i := index; i < len(nums); i++ {
		if nums[i] != target {
			break
		}
		res++
	}
	return
}

func binSearch(nums []int, target int) (index int) {
	if len(nums) == 0 {
		return -1
	}
	if len(nums) == 1 && nums[0] == target {
		return 0
	}
	if target < nums[0] || target > nums[len(nums)-1] {
		return -1
	}
	l, r := 0, len(nums)-1
	mid := len(nums) / 2
	for l < r {
		if target == nums[mid] {
			return mid
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
		if target > nums[mid] {
			l = mid
		} else {
			r = mid
		}
		mid = (r + l) / 2
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(search([]int{}, 1))
	fmt.Println(search([]int{1}, 1))
	fmt.Println(search([]int{2, 2}, 2))
	fmt.Println(search([]int{1, 2, 2, 3, 4, 4, 4}, 4))
	fmt.Println(search([]int{5, 7, 7, 8, 8, 10}, 1))
	fmt.Println(search([]int{5, 7, 7, 8, 8, 10}, 6))
	fmt.Println(search([]int{5, 7, 7, 8, 8, 10}, 8))
	fmt.Println(search([]int{5, 8, 8, 8, 8, 10}, 8))
}
