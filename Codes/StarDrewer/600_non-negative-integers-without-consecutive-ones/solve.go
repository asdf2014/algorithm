//Given a positive integer n, return the number of the integers in the range [0,
// n] whose binary representations do not contain consecutive ones.
//
//
// Example 1:
//
//
//Input: n = 5
//Output: 5
//Explanation:
//Here are the non-negative integers <= 5 with their corresponding binary
//representations:
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//Among them, only integer 3 disobeys the rule (two consecutive ones) and the
//other 5 satisfy the rule.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 2
//
//
// Example 3:
//
//
//Input: n = 2
//Output: 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 10⁹
//
// Related Topics 动态规划 👍 210 👎 0

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
var dp = []int{1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465}

func findIntegers(n int) (res int) {
	this := fmt.Sprintf("%b", n)
	for i, char := range this {
		if findDuplicated(this[:i]) {
			continue
		}
		if char == '1' {
			res += dp[len(this)-1-i]
		}
	}
	if !findDuplicated(this) {
		res++
	}
	return
}

func findDuplicated(this string) bool {
	for i := 0; i < len(this)-1; i++ {
		if this[i] == this[i+1] && this[i] == '1' {
			return true
		}
	}
	return false
}

// 暴力对照组
var cache = []int{1, 2}

func findIntegers1(n int) int {
	if n < len(cache) {
		return cache[n]
	}
	for i := len(cache); i <= n; i++ {
		this := fmt.Sprintf("%b", i)
		if findDuplicated(this) {
			cache = append(cache, cache[i-1])
		} else {
			cache = append(cache, cache[i-1]+1)
		}
	}
	return cache[n]
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	// dp = [1,2]
	//for i := dp[len(dp)-1]; i <= len(fmt.Sprintf("%b", 1000000000)); i++ {
	//	dp = append(dp, dp[i-1] + dp[i-2])
	//}
	//for _, i2 := range dp {
	//	fmt.Printf("%v,", i2)
	//}
	fmt.Println(findIntegers(17))
	fmt.Println(findIntegers1(17))
}
