//Given two strings word1 and word2, return the minimum number of steps
//required to make word1 and word2 the same.
//
// In one step, you can delete exactly one character in either string.
//
//
// Example 1:
//
//
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make
//"eat" to "ea".
//
//
// Example 2:
//
//
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
//
//
//
// Constraints:
//
//
// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.
//
// Related Topics 字符串 动态规划 👍 235 👎 0

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)

func minDistance(word1 string, word2 string) int {
	lcs := longestCommonSubsequence(word1, word2)
	return len(word1) + len(word2) - 2*lcs
}

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
	fmt.Println(minDistance("sea", "eat"))
}
