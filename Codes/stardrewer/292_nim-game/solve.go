//You are playing the following Nim Game with your friend:
//
//
// Initially, there is a heap of stones on the table.
// You and your friend will alternate taking turns, and you go first.
// On each turn, the person whose turn it is will remove 1 to 3 stones from the
//heap.
// The one who removes the last stone is the winner.
//
//
// Given n, the number of stones in the heap, return true if you can win the
//game assuming both you and your friend play optimally, otherwise return false.
//
//
// Example 1:
//
//
//Input: n = 4
//Output: false
//Explanation: These are the possible outcomes:
//1. You remove 1 stone. Your friend removes 3 stones, including the last stone.
// Your friend wins.
//2. You remove 2 stones. Your friend removes 2 stones, including the last
//stone. Your friend wins.
//3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
//In all outcomes, your friend wins.
//
//
// Example 2:
//
//
//Input: n = 1
//Output: true
//
//
// Example 3:
//
//
//Input: n = 2
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 脑筋急转弯 数学 博弈 👍 458 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
var f = []bool{true, true, true, true}
var useCache = false

func canWinNim(n int) bool {
	// 麻了
	return n%4 != 0

	if useCache { // 递推+缓存法
		if n < len(f) {
			return f[n]
		}
		for i := len(f); i <= n; i++ {
			f = append(f, !f[i-1] || !f[i-2] || !f[i-3])
		}
		return f[n]
	} else { // 递推不缓存法
		if n <= 3 {
			return true
		}
		a, b, c := true, true, true
		for i := 4; i <= n; i++ {
			a, b, c = b, c, !a || !b || !c
		}
		return c
	}

}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	for i := 1; i < 100; i++ {
		fmt.Println(canWinNim(i))
	}
}
