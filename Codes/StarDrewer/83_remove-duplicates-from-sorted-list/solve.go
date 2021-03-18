package main

// ListNode you know.
type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	pre := &ListNode{0, head}
	for head != nil {
		if head.Next != nil && head.Val == head.Next.Val {
			head.Next = head.Next.Next
		} else {
			head = head.Next //这里很坑啊，因为不一定只重复一次，所以只有不重复的时候往下一位走才正确
		}
	}
	return pre.Next
}
