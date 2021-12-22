//Given the API rand7() that generates a uniform random integer in the range [1,
// 7], write a function rand10() that generates a uniform random integer in the
//range [1, 10]. You can only call the API rand7(), and you shouldn't call any
//other API. Please do not use a language's built-in random API.
//
// Each test case will have one internal argument n, the number of times that
//your implemented function rand10() will be called while testing. Note that this
//is not an argument passed to rand10().
//
// Follow up:
//
//
// What is the expected value for the number of calls to rand7() function?
// Could you minimize the number of calls to rand7()?
//
//
//
// Example 1:
// Input: n = 1
//Output: [2]
// Example 2:
// Input: n = 2
//Output: [2,8]
// Example 3:
// Input: n = 3
//Output: [3,8,10]
//
//
// Constraints:
//
//
// 1 <= n <= 10⁵
//
// Related Topics 数学 拒绝采样 概率与统计 随机化 👍 290 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func rand7() int {
	return 0
}

func rand10() int {
	var a, b int
	for {
		a = rand7() // a [1,6] % 2
		if a == 7 {
			continue
		} else {
			break
		}
	}
	for {
		b = rand7() // b [1,5]
		if b > 5 {
			continue
		} else {
			break
		}
	}

	if a%2 == 1 {
		return b
	} else {
		return b + 5
	}

}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(rand10())
}
