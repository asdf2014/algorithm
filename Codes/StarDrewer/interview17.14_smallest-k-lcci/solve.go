//Design an algorithm to find the smallest K numbers in an array.
//
// Example:
//
//
//Input:  arr = [1,3,5,7,2,4,6,8], k = 4
//Output:  [1,2,3,4]
//
//
// Note:
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 140 👎 0

package main

import (
	"fmt"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)
func smallestK(arr []int, k int) []int {
	sort.Ints(arr)
	return arr[:k]
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println()
}
