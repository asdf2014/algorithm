package main

import (
	"fmt"
)

// ListNode Definition for singly-linked list.
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

//NextN next n node.
func NextN(l *ListNode, n int) (*ListNode, int) {
	// 返回节点l挪动n位置后的情况，如果可挪动的小于n(即到达末尾)，那么停止
	this := l
	i := 0
	for ; i < n && l != nil; i++ {
		if this.Next != nil {
			this = this.Next
		} else {
			break
		}
	}
	return this, i
}
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	// 0 ms >100.00%, 2.2 MB >97.93%
	pre := ListNode{0, head}
	i := head
	j, step := NextN(head, n)
	for pre.Next != nil {
		if step <= n && j.Next == nil {
			// n恰好等于链表长度的情况, 此时i是第一个节点, 令i变为第一个节点的前一个节点pre
			if pre.Next == i && step < n {
				i = &pre
			}
			// 删除 i 的后一个节点
			after := ListNode{0, i.Next.Next}
			i.Next.Next = nil
			i.Next = after.Next
			break
		}
		j, step = NextN(j, n)
		i, _ = NextN(i, step)
	}
	return pre.Next
}

func main() {
	n1 := ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	n1.Print()
	removeNthFromEnd(&n1, 2).Print()

	n2 := &ListNode{1, &ListNode{}}
	n2.Print()
	removeNthFromEnd(n2, 1).Print()

	n3 := &ListNode{1, nil}
	n3.Print()
	removeNthFromEnd(n3, 1).Print()
	fmt.Println("******")
	removeNthFromEnd(nil, 1).Print()

}
