//Balanced strings are those that have an equal quantity of 'L' and 'R'
//characters.
//
// Given a balanced string s, split it in the maximum amount of balanced
//strings.
//
// Return the maximum amount of split balanced strings.
//
//
// Example 1:
//
//
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring
//contains same number of 'L' and 'R'.
//
//
// Example 2:
//
//
//Input: s = "RLLLLRRRLR"
//Output: 3
//Explanation: s can be split into "RL", "LLLRRR", "LR", each substring
//contains same number of 'L' and 'R'.
//
//
// Example 3:
//
//
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
//
//
// Example 4:
//
//
//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", since each substring
//contains an equal number of 'L' and 'R'
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s[i] is either 'L' or 'R'.
// s is a balanced string.
//
// Related Topics 贪心 字符串 计数 👍 123 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func balancedStringSplit(s string) (res int) {
	var l, r int
	for i := 0; i < len(s); i++ {
		if s[i] == 'L' {
			l++
		} else {
			r++
		}
		if l+r != 0 && l == r {
			res++
			l = 0
			r = 0
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(balancedStringSplit("RLRRLLRLRL"))
}
