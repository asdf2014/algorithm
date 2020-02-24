package main

import (
	"testing"
)

func TestDeleteDuplicates(t *testing.T) {

	case1 := &ListNode{1, &ListNode{1, &ListNode{2, nil}}}
	res1 := deleteDuplicates(case1)
	esp1 := &ListNode{1, &ListNode{2, nil}}
	if res1.Val != esp1.Val || res1.Next.Val != esp1.Next.Val || res1.Next.Next != esp1.Next.Next {
		t.Errorf("not match for case1")
	}

	case2 := &ListNode{1, &ListNode{1, &ListNode{1, nil}}}
	res2 := deleteDuplicates(case2)
	esp2 := &ListNode{1, nil}
	if res2.Val != esp2.Val || res2.Next != esp2.Next {
		t.Errorf("not match for case2")
	}
}
