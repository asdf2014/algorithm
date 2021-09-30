//English description is not available for the problem. Please switch to
//Chinese.
// Related Topics 字符串 👍 156 👎 0

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//示例 1：
//
//输入：s = "We are happy."
//输出："We%20are%20happy."
//
//限制：
//0 <= s 的长度 <= 10000

package main

import (
	"fmt"
	"strings"
)

//leetcode submit region begin(Prohibit modification and deletion)
func replaceSpace(s string) string {
	return strings.ReplaceAll(s, " ", "%20")
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(replaceSpace("We are happy."))
}
