package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	// 12 ms, 5.2 MB
	res := ListNode{}
	r := &res

	temp := 0

	for l1 != nil || l2 != nil || temp != 0 {
		thisAdd := temp
		temp = 0
		if l1 != nil {
			thisAdd += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			thisAdd += l2.Val
			l2 = l2.Next
		}

		if thisAdd >= 10 {
			thisAdd -= 10
			temp = 1
		}
		r.Val = thisAdd
		r.Next = &ListNode{}
		r = r.Next
	}

	// 主要是为了清除最后一位的空ListNode，否则会被判错
	r = &res
	for {
		if r.Next.Val == 0 && r.Next.Next == nil {
			r.Next = nil
			break
		}
		r = r.Next
	}
	return &res
}
func main() {
	l1 := ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	l2 := ListNode{5, &ListNode{6, &ListNode{4, nil}}}
	res := addTwoNumbers(&l1, &l2)
	fmt.Println(res, res.Next, res.Next.Next, res.Next.Next.Next)
}
