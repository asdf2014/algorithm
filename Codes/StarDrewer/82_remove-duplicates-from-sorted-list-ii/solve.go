package main

//ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	i := &ListNode{0, head}
	pre := &ListNode{0, i}
	for i != nil && i.Next != nil {
		j := i.Next
		baseVal := j.Val

		for j != nil {
			if j.Next != nil {
				if j.Next.Val == baseVal {
					j = j.Next //相同值,所以在相同值区间,则j继续右移
				} else {
					if j == i.Next { //不同值,且没有在相同值区间,则i右移
						i = i.Next
						break
					} else { //[i:next.Next]是相同值区间,此时可以通过i.Next = j.Next将其断掉了
						i.Next = j.Next
						break
					}
				}
			} else { //j是最后一个值
				if j.Val == baseVal && j != i.Next { //如果j在相同区间
					i.Next = nil
				} else {
					i.Next = j
					i = j //为了退出循环
				}
				break
			}
		}

	}
	return pre.Next.Next
}
