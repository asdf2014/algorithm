//You are given an array people where people[i] is the weight of the iᵗʰ person,
// and an infinite number of boats where each boat can carry a maximum weight of
//limit. Each boat carries at most two people at the same time, provided the sum
//of the weight of those people is at most limit.
//
// Return the minimum number of boats to carry every given person.
//
//
// Example 1:
//
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//
//
// Example 2:
//
//
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
//
//
// Example 3:
//
//
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
//
//
//
// Constraints:
//
//
// 1 <= people.length <= 5 * 10⁴
// 1 <= people[i] <= limit <= 3 * 10⁴
//
// Related Topics 贪心 数组 双指针 排序 👍 138 👎 0

package main

import (
	"fmt"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)
// 贪心解法
func numRescueBoats(people []int, limit int) (res int) {
	sort.Ints(people)
	l, r := 0, len(people)-1
	for l <= r {
		if people[l]+people[r] > limit {
			r--
		} else {
			l++
			r--
		}
		res++
	}
	return
}

// 不排序的非贪心解法
// 时间 4% 空间 100%
//func numRescueBoats(people []int, limit int) (res int) {
//	// 建立 people weight 对应人数的映射
//	peopleMap := map[int]int{}
//	for _, person := range people {
//		peopleMap[person] ++
//	}
//
//	for _, person := range people {
//		if num := peopleMap[person]; num > 0 {
//			if person <= limit {
//				// 如果题目限制不是每个船载2个人应该怎么做x
//				for personRest := limit - person; personRest >= 0; personRest-- {
//					if personRest == 0 {
//						peopleMap[person]--
//						res++
//						break
//					}
//
//					numRest := peopleMap[personRest]
//					if person == personRest {
//						if numRest > 1 {
//							peopleMap[personRest]--
//							peopleMap[person]--
//							res++
//							break
//						}
//					} else {
//						if numRest > 0 {
//							peopleMap[personRest]--
//							peopleMap[person]--
//							res++
//							break
//						}
//					}
//
//				}
//			}
//		}
//	}
//	return
//}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(numRescueBoats([]int{}, 3))
	fmt.Println(numRescueBoats([]int{1, 2}, 3))
	fmt.Println(numRescueBoats([]int{3, 1, 7}, 7))
	fmt.Println(numRescueBoats([]int{2, 2}, 6))
	fmt.Println(numRescueBoats([]int{1, 2}, 3))
	fmt.Println(numRescueBoats([]int{3, 2, 2, 1}, 3))
	fmt.Println(numRescueBoats([]int{3, 5, 3, 4}, 5))
}
