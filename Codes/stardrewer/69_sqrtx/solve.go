//Given a non-negative integer x, compute and return the square root of x.
//
// Since the return type is an integer, the decimal digits are truncated, and
//only the integer part of the result is returned.
//
// Note: You are not allowed to use any built-in exponent function or operator,
//such as pow(x, 0.5) or x ** 0.5.
//
//
// Example 1:
//
//
//Input: x = 4
//Output: 2
//
//
// Example 2:
//
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part
//is truncated, 2 is returned.
//
//
// Constraints:
//
//
// 0 <= x <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 769 👎 0

package main

import (
	"fmt"
	"math"
)

//leetcode submit region begin(Prohibit modification and deletion)
func mySqrt(x int) int {
	left, right := 1, x

	// 简单精确边界
	switch {
	case x >= 10000000000:
		left = 100000
		right = x
	case x >= 100000000:
		left = 10000
		right = 100000
	case x >= 10000000:
		left = 1000
		right = 10000
	case x >= 1000000:
		left = 1000
		right = 10000
	case x >= 100000:
		left = 100
		right = 1000
	case x >= 10000:
		left = 100
		right = 1000
	}
	for left <= right {
		if left == right {
			return left
		}
		if left == right-1 {
			if left*left <= x && right*right > x {
				return left
			}
		}

		this := (left + right) / 2
		pow := this * this
		if pow == x {
			return this
		}

		if pow > x {
			right = this
		} else {
			left = this
		}

	}
	return 0
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	equal := func(x int) bool {
		//return mySqrt(x) == mySqrt(x)
		//return int(math.Sqrt(float64(x))) == int(math.Sqrt(float64(x)))
		return mySqrt(x) == int(math.Sqrt(float64(x)))
	}
	for i := 0; i < 1e8; i++ {
		if !equal(i) {
			fmt.Println(i)
		}
	}
}
