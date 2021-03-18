package main

import (
	"fmt"
	"math"
)

// Min return the min value of two int.
func Min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
func maxNumberOfBalloons(text string) int {
	r := 0
	// 存储每个字母出现次数
	res := [5]int{0, 0, 0, 0, 0}
	for _, v := range text {
		switch v {
		case 'b':
			res[0]++
		case 'a':
			res[1]++
		case 'l':
			res[2]++
		case 'o':
			res[3]++
		case 'n':
			res[4]++
		}
	}
	// 去重
	res[2] /= 2
	res[3] /= 2

	// 选出最小值，即为结果
	min := math.MaxInt32
	for _, v := range res {
		min = Min(min, v)
	}
	if min != math.MaxInt32 {
		r = min
	}

	return r
}

func main() {
	fmt.Println(maxNumberOfBalloons("nlaebolko"))
	fmt.Println(maxNumberOfBalloons("loonbalxballpoon"))
	fmt.Println(maxNumberOfBalloons("leetcode"))
}
