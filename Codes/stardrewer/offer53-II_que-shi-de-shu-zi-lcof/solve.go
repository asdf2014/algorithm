//English description is not available for the problem. Please switch to
//Chinese. Related Topics 位运算 数组 哈希表 数学 二分查找 👍 170 👎 0

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

//示例 1:
//输入: [0,1,3]
//输出: 2
//示例2:

//输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//限制：
//1 <= 数组长度 <= 10000

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
// TODO 二分
//func missingNumber(nums []int) int {
//	if len(nums) == 1 && nums[0] != 0 {
//		return 0
//	}
//	l, r := 0, len(nums)-1
//	for l < r {
//		mid := (l + r) / 2
//
//	}
//}

func missingNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] != i {
			return i
		}
	}
	return nums[len(nums)-1] + 1
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(missingNumber([]int{0}))
	fmt.Println(missingNumber([]int{0, 1}))
}
