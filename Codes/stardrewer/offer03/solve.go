//English description is not available for the problem. Please switch to
//Chinese.
// Related Topics 数组 哈希表 排序 👍 536 👎 0

// 找出数组中重复的数字。
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

//示例 1：
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3

//限制：
//2 <= n <= 100000

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func findRepeatNumber(nums []int) int {
	cache := map[int]struct{}{}
	for i := 0; i < len(nums); i++ {
		if _, ok := cache[nums[i]]; ok {
			return nums[i]
		} else {
			cache[nums[i]] = struct{}{}
		}
	}
	return 0
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(findRepeatNumber([]int{2, 3, 1, 0, 2, 5, 3}))
}
