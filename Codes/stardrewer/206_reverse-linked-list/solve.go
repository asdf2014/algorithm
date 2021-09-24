//Given the head of a singly linked list, reverse the list, and return the
//reversed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//
//
// Example 2:
//
//
//Input: head = [1,2]
//Output: [2,1]
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
//
//
//
// Follow up: A linked list can be reversed either iteratively or recursively.
//Could you implement both?
// Related Topics 递归 链表 👍 1920 👎 0

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

// 为了方便阅读，单独写了一个链表节点索引结构
type IndexNode struct {
	Node *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	var l, r IndexNode
	l.Node = head
	r.Node = head.Next

	l.Node.Next = nil // 使头结点变尾结点

	for r.Node != nil {
		tmp := r.Node.Next   // 保存右链index的下一位
		r.Node.Next = l.Node // 使右链index的节点指向左链
		l.Node = r.Node      // 左链index++
		r.Node = tmp         // 右链index++
	}

	return l.Node
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	res := reverseList(&ListNode{
		Val: 0,
		Next: &ListNode{
			Val: 1,
			Next: &ListNode{
				Val:  2,
				Next: nil,
			},
		},
	})
	for p := res; p != nil; p = p.Next {
		fmt.Printf("->%v", p.Val)
	}
	fmt.Printf("\n")

}
