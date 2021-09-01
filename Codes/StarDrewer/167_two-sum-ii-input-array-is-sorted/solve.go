//Given an array of integers numbers that is already sorted in non-decreasing
//order, find two numbers such that they add up to a specific target number.
//
// Return the indices of the two numbers (1-indexed) as an integer array answer
//of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
//
// The tests are generated such that there is exactly one solution. You may not
//use the same element twice.
//
//
// Example 1:
//
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//
//
// Example 2:
//
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//
//
// Example 3:
//
//
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//
//
//
// Constraints:
//
//
// 2 <= numbers.length <= 3 * 10⁴
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.
//
// Related Topics 数组 双指针 二分查找 👍 577 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func twoSum(numbers []int, target int) []int {
	var l, r = 0, len(numbers) - 1
	for l < r {
		if (numbers[l] + numbers[r]) == target {
			return []int{l + 1, r + 1}
		} else if (numbers[l] + numbers[r]) < target {
			l++
		} else if (numbers[l] + numbers[r]) > target {
			r--
		}
	}
	return nil
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
	fmt.Println(twoSum([]int{2, 3, 4}, 6))
	fmt.Println(twoSum([]int{-1, 0}, -1))
}

