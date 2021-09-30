//English description is not available for the problem. Please switch to
//Chinese. Related Topics 队列 哈希表 字符串 计数 👍 141 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func firstUniqChar(s string) byte {

	cache := map[byte]int{}
	for i := 0; i < len(s); i++ {
		cache[s[i]]++
	}

	for i := 0; i < len(s); i++ {
		if cache[s[i]] == 1 {
			return s[i]
		}
	}
	return ' '
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(string(firstUniqChar("abaccdeff")))
	fmt.Println(string(firstUniqChar("")))
}
