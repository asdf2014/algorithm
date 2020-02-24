package main

import "fmt"

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	preRes := &ListNode{0, head.Next}
	p := &ListNode{0, head}
	for p.Next != nil && p.Next.Next != nil {
		a, b, last := p.Next, p.Next.Next, p.Next.Next.Next

		p.Next = b
		b.Next = a
		a.Next = last

		p = a
	}
	return preRes.Next
}

func main() {
	inputNode1 := ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, nil}}}}
	fmt.Println(inputNode1, inputNode1.Next, inputNode1.Next.Next, inputNode1.Next.Next.Next)
	res1 := swapPairs(&inputNode1)
	fmt.Println(res1, res1.Next, res1.Next.Next, res1.Next.Next.Next)
	fmt.Println()

	inputNode2 := ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	fmt.Println(inputNode2, inputNode2.Next, inputNode2.Next.Next, inputNode2.Next.Next.Next, inputNode2.Next.Next.Next.Next)
	res2 := swapPairs(&inputNode2)
	fmt.Println(res2, res2.Next, res2.Next.Next, res2.Next.Next.Next, res2.Next.Next.Next.Next)
	fmt.Println()

	inputNode3 := ListNode{1, nil}
	fmt.Println(inputNode3)
	res3 := swapPairs(&inputNode3)
	fmt.Println(res3)
	fmt.Println()

	fmt.Println(nil)
	res4 := swapPairs(nil)
	fmt.Println(res4)
}
