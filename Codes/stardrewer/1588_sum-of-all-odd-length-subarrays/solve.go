package main

import (
	"fmt"
)

func sumOddLengthSubarrays(arr []int) (res int) {
	for i := 1; i <= len(arr); i += 2 {
		// 奇数子数组长度i

		// 滑动窗口
		for j := 0; j+i <= len(arr); j++ {
			for k := j; k < j+i; k++ {
				res += arr[k]
			}
		}
	}
	return
}

func main() {
	fmt.Println(sumOddLengthSubarrays([]int{1, 4, 2, 5, 3}))
	fmt.Println(sumOddLengthSubarrays([]int{1, 2}))
	fmt.Println(sumOddLengthSubarrays([]int{10, 11, 12}))
	fmt.Println(sumOddLengthSubarrays([]int{}))
}
