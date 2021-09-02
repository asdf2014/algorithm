//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 栈 递归 链表 双指针 👍 180 👎 0

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reversePrint(head *ListNode)(res []int) {
	var tmp []int
	for p := head; p != nil; p = p.Next {
		tmp = append(tmp, p.Val)
	}
	for i := len(tmp)-1; i >= 0; i-- {
		res = append(res, tmp[i])
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(reversePrint(&ListNode{
		Val:  1,
		Next: &ListNode{
			Val:  3,
			Next: &ListNode{
				Val:  2,
				Next: nil,
			},
		},
	}))
}
