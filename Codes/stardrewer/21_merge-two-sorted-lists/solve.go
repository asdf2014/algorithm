package main

import "fmt"

//ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

//Print print ListNode.
func (l *ListNode) Print() {
	this := l
	for this != nil {
		next := "node"
		if this.Next == nil {
			next = "nil"
		}
		fmt.Printf("(%d, %s)", this.Val, next)

		this = this.Next
		if this != nil {
			fmt.Printf(" -> ")
		} else {
			fmt.Println()
			break
		}
	}
}
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	// 0 ms >100.00%, 2.6 MB >60.5%
	pre := &ListNode{}

	for this := pre; ; this = this.Next {
		// 某一个链表空了
		if l1 == nil {
			this.Next = l2
			break
		}
		if l2 == nil {
			this.Next = l1
			break
		}

		// 两个链表都不空
		if l1.Val < l2.Val {
			this.Next = &ListNode{l1.Val, nil}
			l1 = l1.Next
		} else {
			this.Next = &ListNode{l2.Val, nil}
			l2 = l2.Next
		}
	}

	return pre.Next
}
func main() {
	res := mergeTwoLists(
		&ListNode{1, &ListNode{2, &ListNode{4, nil}}},
		&ListNode{1, &ListNode{3, &ListNode{4, nil}}},
	)
	fmt.Println(res)
	res.Print()
}
