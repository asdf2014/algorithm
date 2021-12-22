//Given the head of a singly linked list and an integer k, split the linked
//list into k consecutive linked list parts.
//
// The length of each part should be as equal as possible: no two parts should
//have a size differing by more than one. This may lead to some parts being null.
//
// The parts should be in the order of occurrence in the input list, and parts
//occurring earlier should always have a size greater than or equal to parts
//occurring later.
//
// Return an array of the k parts.
//
//
// Example 1:
//
//
//Input: head = [1,2,3], k = 5
//Output: [[1],[2],[3],[],[]]
//Explanation:
//The first element output[0] has output[0].val = 1, output[0].next = null.
//The last element output[4] is null, but its string representation as a
//ListNode is [].
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
//Output: [[1,2,3,4],[5,6,7],[8,9,10]]
//Explanation:
//The input has been split into consecutive parts with size difference at most 1
//, and earlier parts are a larger size than the later parts.
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 1000].
// 0 <= Node.val <= 1000
// 1 <= k <= 50
//
// Related Topics 链表 👍 223 👎 0

package main

import (
	"fmt"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (ln ListNode) String() string {
	var res []string
	for p := &ln; p != nil; p = p.Next {
		res = append(res, fmt.Sprint(p.Val))
	}
	return "[" + strings.Join(res, ",") + "]"
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func splitListToParts(head *ListNode, k int) (res []*ListNode) {
	var length int
	for p := head; p != nil; p = p.Next {
		length++
	}
	mod := length % k
	each := length / k
	for p := head; p != nil; {
		res = append(res, p)
		if mod == 0 {
			for i := 0; i < each-1; i++ {
				p = p.Next
			}
		} else {
			mod--
			for i := 0; i < each; i++ {
				p = p.Next
			}
		}
		tmp := p
		p = p.Next
		tmp.Next = nil
	}
	for i := len(res); i < k; i++ {
		res = append(res, nil)
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(splitListToParts(&ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val:  3,
				Next: nil,
			},
		},
	}, 5))
	fmt.Println(splitListToParts(&ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
						Next: &ListNode{
							Val: 6,
							Next: &ListNode{
								Val: 7,
								Next: &ListNode{
									Val: 8,
									Next: &ListNode{
										Val: 9,
										Next: &ListNode{
											Val:  10,
											Next: nil,
										},
									},
								},
							},
						},
					},
				},
			},
		},
	}, 3))
}
