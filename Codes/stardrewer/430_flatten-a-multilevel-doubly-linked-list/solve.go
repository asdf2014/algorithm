//You are given a doubly linked list which in addition to the next and previous
//pointers, it could have a child pointer, which may or may not point to a
//separate doubly linked list. These child lists may have one or more children of their
//own, and so on, to produce a multilevel data structure, as shown in the example
//below.
//
// Flatten the list so that all the nodes appear in a single-level, doubly
//linked list. You are given the head of the first level of the list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//Explanation:
//
//The multilevel linked list in the input is as follows:
//
//
//
//After flattening the multilevel linked list it becomes:
//
//
//
//
// Example 2:
//
//
//Input: head = [1,2,null,3]
//Output: [1,3,2]
//Explanation:
//
//The input multilevel linked list is as follows:
//
//  1---2---NULL
//  |
//  3---NULL
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
//
// How multilevel linked list is represented in test case:
//
// We use the multilevel linked list from Example 1 above:
//
//
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//
// The serialization of each level is as follows:
//
//
//[1,2,3,4,5,6,null]
//[7,8,9,10,null]
//[11,12,null]
//
//
// To serialize all levels together we will add nulls in each level to signify
//no node connects to the upper node of the previous level. The serialization
//becomes:
//
//
//[1,2,3,4,5,6,null]
//[null,null,7,8,9,10,null]
//[null,11,12,null]
//
//
// Merging the serialization of each level and removing trailing nulls we
//obtain:
//
//
//[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//
//
// Constraints:
//
//
// The number of Nodes will not exceed 1000.
// 1 <= Node.val <= 10⁵
//
// Related Topics 深度优先搜索 链表 双向链表 👍 291 👎 0

package main

import "fmt"

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Prev *Node
 *     Next *Node
 *     Child *Node
 * }
 */

func flatten(root *Node) *Node {
	var stack []*Node
	for p := root; p != nil; p = p.Next {
		if p.Child != nil {
			if p.Next != nil {
				stack = append(stack, p.Next)
			}
			p.Next = p.Child
		}
		if p.Next == nil {
			if len(stack) != 0 {
				p.Next = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
		}
	}
	for p := root; p != nil; p = p.Next {
		p.Child = nil
		if p.Next != nil {
			p.Next.Prev = p
		}
	}
	return root
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(flatten(&Node{
		Val:  1,
		Prev: nil,
		Next: &Node{
			Val:  2,
			Prev: nil,
			Next: &Node{
				Val:  3,
				Prev: nil,
				Next: &Node{
					Val:  4,
					Prev: nil,
					Next: &Node{
						Val:  5,
						Prev: nil,
						Next: &Node{
							Val:   6,
							Prev:  nil,
							Next:  nil,
							Child: nil,
						},
						Child: nil,
					},
					Child: nil,
				},
				Child: &Node{
					Val:  7,
					Prev: nil,
					Next: &Node{
						Val:  8,
						Prev: nil,
						Next: nil,
						Child: &Node{
							Val:  11,
							Prev: nil,
							Next: &Node{
								Val:   12,
								Prev:  nil,
								Next:  nil,
								Child: nil,
							},
							Child: nil,
						},
					},
					Child: nil,
				},
			},
			Child: nil,
		},
		Child: nil,
	}))
	fmt.Println(flatten(&Node{
		Val:  1,
		Prev: nil,
		Next: &Node{
			Val:  2,
			Prev: nil,
			Next: &Node{
				Val:  3,
				Prev: nil,
				Next: &Node{
					Val:  4,
					Prev: nil,
					Next: &Node{
						Val:  5,
						Prev: nil,
						Next: &Node{
							Val:   6,
							Prev:  nil,
							Next:  nil,
							Child: nil,
						},
						Child: nil,
					},
					Child: nil,
				},
				Child: &Node{
					Val:  7,
					Prev: nil,
					Next: &Node{
						Val:  8,
						Prev: nil,
						Next: &Node{
							Val:  9,
							Prev: nil,
							Next: &Node{
								Val:   10,
								Prev:  nil,
								Next:  nil,
								Child: nil,
							},
							Child: nil,
						},
						Child: &Node{
							Val:  11,
							Prev: nil,
							Next: &Node{
								Val:   12,
								Prev:  nil,
								Next:  nil,
								Child: nil,
							},
							Child: nil,
						},
					},
					Child: nil,
				},
			},
			Child: nil,
		},
		Child: nil,
	}))
}
