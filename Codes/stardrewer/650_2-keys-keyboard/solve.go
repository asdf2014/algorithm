//There is only one character 'A' on the screen of a notepad. You can perform
//two operations on this notepad for each step:
//
//
// Copy All: You can copy all the characters present on the screen (a partial
//copy is not allowed).
// Paste: You can paste the characters which are copied last time.
//
//
// Given an integer n, return the minimum number of operations to get the
//character 'A' exactly n times on the screen.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: 3
//Explanation: Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= n <= 1000
//
// Related Topics 数学 动态规划 👍 386 👎 0

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
func minSteps(n int) (ans int) {
	for i := 2; i*i <= n; i++ {
		for n%i == 0 {
			n /= i
			ans += i
		}
	}
	if n > 1 {
		ans += n
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	for i := 1; i < 10; i++ {
		fmt.Println("i =", i, "res =", minSteps(i))
	}
}
