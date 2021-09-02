//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 链表 双指针 👍 244 👎 0

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

//例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

//示例：
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//返回链表 4->5.

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
func getKthFromEnd(head *ListNode, k int) *ListNode {
	l, r := head, head
	var i int
	for l != nil && r != nil {
		if i == k {
			l = l.Next
			r = r.Next
		} else {
			r = r.Next
			i++
		}
	}
	return l
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(getKthFromEnd(&ListNode{
		Val:  1,
		Next: &ListNode{
			Val:  2,
			Next: &ListNode{
				Val:  3,
				Next: &ListNode{
					Val:  4,
					Next: &ListNode{
						Val:  5,
						Next: nil,
					},
				},
			},
		},
	}, 2))
}
