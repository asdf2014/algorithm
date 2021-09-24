//Given two strings text1 and text2, return the length of their longest common
//subsequence. If there is no common subsequence, return 0.
//
// A subsequence of a string is a new string generated from the original string
//with some characters (can be none) deleted without changing the relative order
//of the remaining characters.
//
//
// For example, "ace" is a subsequence of "abcde".
//
//
// A common subsequence of two strings is a subsequence that is common to both
//strings.
//
//
// Example 1:
//
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.
//
// Related Topics 字符串 动态规划 👍 681 👎 0

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)

func longestCommonSubsequence(text1 string, text2 string) int {
	f := make([][]int, len(text1)+1)
	for i := range f {
		f[i] = make([]int, len(text2)+1)
	}
	for i := 0; i < len(text1); i++ {
		for j := 0; j < len(text2); j++ {
			if text1[i] == text2[j] {
				f[i+1][j+1] = 1 + f[i][j]
			} else {
				f[i+1][j+1] = maxInt(f[i][j+1], f[i+1][j])
			}
		}
	}
	return f[len(text1)][len(text2)]
}
func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(longestCommonSubsequence("abcde", "ace"))
}
