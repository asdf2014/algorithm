package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	// 780 ms >100%, 272.5 MB >5.22%
	var res [][]int

	sort.Ints(nums)
	// 一个基准值 k, 加上 slice[k:] 的头尾两端 i, j 两个指针
	for k := 0; k < len(nums)-1 && nums[k] <= 0; k++ {
		// 去重: 重复基准值 k，跳过
		if k > 0 && nums[k] == nums[k-1] {
			continue
		}

		for i, j := k+1, len(nums)-1; i < j; {
			// 去重: 重复值 i, j的处理
			if i-1 > k && nums[i] == nums[i-1] {
				i++
				continue
			}
			if j+1 < len(nums)-1 && nums[j] == nums[j+1] {
				j--
				continue
			}

			// 结果取值逻辑 + 指针 i, j 的移动判定
			if this := nums[k] + nums[i] + nums[j]; this == 0 {
				res = append(res, []int{nums[k], nums[i], nums[j]})
				i++
				j--
			} else if this > 0 {
				j--
			} else {
				i++
			}
		}

	}
	return res
}

func main() {
	fmt.Println(threeSum([]int{-1, -1, 0, 1, 2, -1, -4, -4}))
	fmt.Println(threeSum([]int{-1, -1, 2, 2}))
	fmt.Println(threeSum([]int{1, -1, -1, 0}))
	fmt.Println(threeSum([]int{0, 0, 0}))
	fmt.Println(threeSum([]int{3, 0, -2, -1, 1, 2}))
}
