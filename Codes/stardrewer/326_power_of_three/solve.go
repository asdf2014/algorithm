//Given an integer n, return true if it is a power of three. Otherwise, return
//false.
//
// An integer n is a power of three, if there exists an integer x such that n ==
// 3ˣ.
//
//
// Example 1:
// Input: n = 27
//Output: true
// Example 2:
// Input: n = 0
//Output: false
// Example 3:
// Input: n = 9
//Output: true
// Example 4:
// Input: n = 45
//Output: false
//
//
// Constraints:
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//Follow up: Could you solve it without loops/recursion? Related Topics 递归 数学 👍
// 207 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func isPowerOfThree(n int) bool {
	if n == 0 {
		return false
	}
	for n != 1 {
		if 3*(n/3) != n {
			return false
		}
		n /= 3
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(isPowerOfThree(27))
	fmt.Println(isPowerOfThree(0))
	fmt.Println(isPowerOfThree(1))
	fmt.Println(isPowerOfThree(2))
	fmt.Println(isPowerOfThree(3))
	fmt.Println(isPowerOfThree(4))
	fmt.Println(isPowerOfThree(9))
	fmt.Println(isPowerOfThree(45))
}
