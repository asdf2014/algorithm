//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 递归 链表 👍 293 👎 0

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL

//限制：
//0 <= 节点个数 <= 5000

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

// 反转内存
func reverseList(head *ListNode) (res *ListNode) {
	var next *ListNode
	for p := head; p != nil; p = next {
		next = p.Next
		p.Next = res
		res = p
	}
	return
}

// 只反转值
func reverseListVal(head *ListNode) (res *ListNode) {
	for p := head; p != nil; p = p.Next {
		res = &ListNode{
			Val:  p.Val,
			Next: res,
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(reverseList(&ListNode{
		Val:  1,
		Next: nil,
	}))
	fmt.Println(reverseList(nil))
	fmt.Println(reverseList(&ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val:  5,
						Next: nil,
					},
				},
			},
		},
	}))
}
