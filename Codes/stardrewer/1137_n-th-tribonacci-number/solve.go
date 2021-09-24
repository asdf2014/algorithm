//The Tribonacci sequence Tn is defined as follows:
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
// Given n, return the value of Tn.
//
//
// Example 1:
//
//
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//
//
// Example 2:
//
//
//Input: n = 25
//Output: 1389537
//
//
//
// Constraints:
//
//
// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1.
// Related Topics 记忆化搜索 数学 动态规划 👍 125 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
//var cache = map[int]int{
//	0: 0,
//	1: 1,
//}
var cache = []int{0, 1, 1}

func tribonacci(n int) int {
	//if v, ok := cache[n]; ok {
	//	return v
	//}
	if n < len(cache) {
		return cache[n]
	}
	for i := len(cache); i <= n; i++ {
		cache = append(cache, cache[i-1]+cache[i-2]+cache[i-3])
	}
	return cache[n]
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(tribonacci(4))
}
