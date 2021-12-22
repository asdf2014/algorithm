//You are given n points in the plane that are all distinct, where points[i] = [
//xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance
//between i and j equals the distance between i and k (the order of the tuple matters).
//
//
// Return the number of boomerangs.
//
//
// Example 1:
//
//
//Input: points = [[0,0],[1,0],[2,0]]
//Output: 2
//Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]
//].
//
//
// Example 2:
//
//
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 2
//
//
// Example 3:
//
//
//Input: points = [[1,1]]
//Output: 0
//
//
//
// Constraints:
//
//
// n == points.length
// 1 <= n <= 500
// points[i].length == 2
// -10⁴ <= xi, yi <= 10⁴
// All the points are unique.
//
// Related Topics 数组 哈希表 数学 👍 194 👎 0

package main

import (
	"fmt"
	"math"
)

//leetcode submit region begin(Prohibit modification and deletion)
// i =? j k
// j =? i k
// k =? i j

func numberOfBoomerangs(points [][]int) (ans int) {
	for _, p := range points {
		cnt := map[int]int{}
		for _, q := range points {
			dis := (p[0]-q[0])*(p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1])
			cnt[dis]++
		}
		for _, m := range cnt {
			ans += m * (m - 1)
		}
	}
	return
}

// 没剪枝
func numberOfBoomerangsSlow(points [][]int) (res int) {
	cache := map[int]map[int][]int{}
	for i := 0; i < len(points); i++ {
		for j := i + 1; j < len(points); j++ {
			direction := int(math.Pow(float64(points[j][0]-points[i][0]), 2) + math.Pow(float64(points[j][1]-points[i][1]), 2))
			if _, ok := cache[direction]; !ok {
				cache[direction] = make(map[int][]int)
			}
			cache[direction][i] = append(cache[direction][i], j)
			cache[direction][j] = append(cache[direction][j], i)
		}
	}
	for _, src := range cache {
		for _, dests := range src {
			if n := len(dests); n >= 2 {
				res += n * (n - 1)
			}
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	//fmt.Println(numberOfBoomerangs([][]int{{0, 0}, {1, 0}, {2, 0}}))
	fmt.Println(numberOfBoomerangs([][]int{{1, 1}, {2, 2}, {3, 3}}))
}
