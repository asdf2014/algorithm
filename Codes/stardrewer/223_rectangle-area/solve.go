//Given the coordinates of two rectilinear rectangles in a 2D plane, return the
//total area covered by the two rectangles.
//
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its
//top-right corner (ax2, ay2).
//
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its
//top-right corner (bx2, by2).
//
//
// Example 1:
//
//
//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 =
//2
//Output: 45
//
//
// Example 2:
//
//
//Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2
//= 2
//Output: 16
//
//
//
// Constraints:
//
//
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴
//
// Related Topics 几何 数学 👍 123 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
	s1 := (ax2 - ax1) * (ay2 - ay1)
	s2 := (bx2 - bx1) * (by2 - by1)

	var cover int
	xCover := min(ax2, bx2) - max(ax1, bx1)
	yCover := min(ay2, by2) - max(ay1, by1)
	if xCover > 0 && yCover > 0 {
		cover = yCover * xCover
	}

	return s1 + s2 - cover
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println()
}
