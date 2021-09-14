//Given a string s containing only three types of characters: '(', ')' and '*',
//return true if s is valid.
//
// The following rules define a valid string:
//
//
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//
// '*' could be treated as a single right parenthesis ')' or a single left
//parenthesis '(' or an empty string "".
//
//
//
// Example 1:
// Input: s = "()"
//Output: true
// Example 2:
// Input: s = "(*)"
//Output: true
// Example 3:
// Input: s = "(*))"
//Output: true
//
//
// Constraints:
//
//
// 1 <= s.length <= 100
// s[i] is '(', ')' or '*'.
//
// Related Topics 栈 贪心 字符串 动态规划 👍 387 👎 0

package main

import (
	"container/list"
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
func checkValidString(s string) bool {
	l, any := list.New(), list.New()
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '(':
			l.PushBack(i)
		case '*':
			any.PushBack(i)
		case ')':
			if l.Len() != 0 {
				l.Remove(l.Back())
			} else if any.Len() != 0 {
				any.Remove(any.Back())
			} else {
				return false
			}
		}
	}
	for l.Len() != 0 && any.Len() != 0 {
		lIndex := l.Remove(l.Back()).(int)
		anyIndex := any.Remove(any.Back()).(int)
		if lIndex > anyIndex {
			return false
		}
	}
	if l.Len() == 0 {
		return true
	}
	return false
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(checkValidString("(*)"))
	fmt.Println(checkValidString("(*))"))
	fmt.Println(checkValidString("((*)"))
	fmt.Println(checkValidString("((*))"))
	fmt.Println(checkValidString("()()"))
	fmt.Println(checkValidString("*****"))
}
