//There are n flights that are labeled from 1 to n.
//
// You are given an array of flight bookings bookings, where bookings[i] = [
//firsti, lasti, seatsi] represents a booking for flights firsti through lasti (
//inclusive) with seatsi seats reserved for each flight in the range.
//
// Return an array answer of length n, where answer[i] is the total number of
//seats reserved for flight i.
//
//
// Example 1:
//
//
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
//
//
// Example 2:
//
//
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
//
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 10⁴
// 1 <= bookings.length <= 2 * 10⁴
// bookings[i].length == 3
// 1 <= firsti <= lasti <= n
// 1 <= seatsi <= 10⁴
//
// Related Topics 数组 前缀和 👍 209 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)

// 差分数组
// 举例：对于数组 [1,2,2,4]，其差分数组为 [1,1,0,2]
// 所以只需要操作区间的两个端点的值
// Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
// [10  0 -10   0 0]
// [10 20 -10 -20 0]
// [10 45 -10 -20 0]
// Output: [10 55 45 25 25]
func corpFlightBookings(bookings [][]int, n int) (res []int) {
	res = make([]int, n)

	// 计算差分数组
	var head, tail, value int
	for i := 0; i < len(bookings); i++ {
		head = bookings[i][0] - 1
		tail = bookings[i][1] - 1
		value = bookings[i][2]

		res[head] += value
		if tail+1 < n {
			res[tail+1] -= value
		}
	}

	// 还原差分数组到原始显示方式
	for i := 1; i < n; i++ {
		res[i] += res[i-1]
	}
	return
}

// 暴力(竟然过了)
func corpFlightBookings1(bookings [][]int, n int) (res []int) {
	res = make([]int, n)
	for i := 0; i < len(bookings); i++ {
		for j := bookings[i][0] - 1; j <= bookings[i][1]-1; j++ {
			res[j] += bookings[i][2]
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(corpFlightBookings([][]int{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5))
	fmt.Println(corpFlightBookings([][]int{{1, 2, 10}, {2, 2, 15}}, 2))
}
