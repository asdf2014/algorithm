//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 哈希表 链表 👍 277 👎 0

package main

import "fmt"

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
	cache := map[*Node]*Node{}
	for p := head; p != nil; p = p.Next {
		cache[p] = &Node{
			Val: p.Val,
		}
	}
	for p := head; p != nil; p = p.Next {
		cache[p].Next = cache[p.Next]
		cache[p].Random = cache[p.Random]
	}
	return cache[head]
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println()
}
