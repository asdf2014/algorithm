package main

import "fmt"

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// MAXINT is the 32 bit max int.
const MAXINT = (2 << 30) - 1

func mergeKLists(lists []*ListNode) *ListNode {
	head := &ListNode{}
	pre := &ListNode{0, head}

	for {
		// 找出数组每个元素(头结点)中值最小的那个
		minNode, minIndex := &ListNode{MAXINT, nil}, 0
		for i, p := range lists {
			if p != nil && p.Val < minNode.Val {
				minNode, minIndex = p, i
			}
		}
		//这代表所有头结点
		if minNode.Val == MAXINT {
			break
		}

		//记录这个头节点
		head.Next = minNode
		head = minNode

		//将这个头节点后移1位
		lists[minIndex] = lists[minIndex].Next
	}
	return pre.Next.Next
}
func main() {
	res := mergeKLists([]*ListNode{
		{1, &ListNode{4, &ListNode{5, nil}}},
		{1, &ListNode{3, &ListNode{4, nil}}},
		{2, &ListNode{6, nil}},
	})
	fmt.Println(res, res.Next, res.Next.Next, res.Next.Next.Next, res.Next.Next.Next.Next,
		res.Next.Next.Next.Next.Next, res.Next.Next.Next.Next.Next.Next, res.Next.Next.Next.Next.Next.Next.Next,
	)

	fmt.Println(mergeKLists([]*ListNode{}))
	fmt.Println(mergeKLists([]*ListNode{{1, nil}, {1, nil}}))

	res1 := mergeKLists([]*ListNode{
		{2, &ListNode{3, nil}},
		{1, nil},
	})
	fmt.Println(res1, res1.Next, res1.Next.Next)
}
