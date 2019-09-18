package main

import (
	"fmt"
	"math"
)

func arrayMaxVal(a *[]int) int {
	// 数组的最大值
	max := 0
	for _, v := range *a {
		if v > max {
			max = v
		}
	}
	return max
}
func arrayMinVal(a *[]int) int {
	// 数组的最小值
	min := math.MaxInt32
	for _, v := range *a {
		if v < min {
			min = v
		}
	}
	return min
}
func maxArea(height []int) int {
	// 676 ms, 5.7 MB
	// 太慢了这个解法
	max := 0
	arrMinval := arrayMinVal(&height)
	for line := arrayMaxVal(&height) - 1; line >= 0; line-- {
		var flagI, flagJ bool
		for i, j := 0, len(height)-1; i <= j; {
			if flagI == false {
				if line < height[i] {
					flagI = true
				} else {
					i++
				}
			}
			if flagJ == false {
				if line < height[j] {
					flagJ = true
				} else {
					j--
				}
			}
			if flagI && flagJ {
				this := (j - i) * (line + 1)
				if this > max {
					max = this
				}
				break
			}
		}
		if line < arrMinval {
			break
		}
	}

	return max
}

//func maxArea(height []int) int {
//	// 49 / 50 个通过测试用例, 最后一个爆了内存，所以不能用二维数组来做
//	var a [][]int
//	for _, v := range height {
//		a = append(a, make([]int, v))
//	}
//	max := 0
//	for line := 0; line < arrayMaxVal(&height); line++ {
//		var flagI, flagJ bool
//		for i, j := 0, len(a)-1; i <= j; {
//			if line < len(a[i]) {
//				flagI = true
//			} else {
//				i++
//			}
//			if line < len(a[j]) {
//				flagJ = true
//			} else {
//				j--
//			}
//			if flagI && flagJ {
//				this := (j - i) * (line + 1)
//				if this > max {
//					max = this
//				}
//				break
//			}
//		}
//	}
//
//	return max
//}
func main() {
	//fmt.Println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
	fmt.Println(maxArea([]int{1, 1, 1, 1}))
}
