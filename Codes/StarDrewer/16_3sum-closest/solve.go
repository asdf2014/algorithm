package main

import (
	"fmt"
	"sort"
)

func abs(x int) int {
	if x < 0 {
		x = -x
	}
	return x
}
func threeSumClosest(nums []int, target int) int {
	// 4 ms >99.49%, 2.7 MB >98.92%
	// 随意slice内的三数之和作为基准来对比
	res := nums[0] + nums[1] + nums[2]
	sort.Ints(nums)
	// 一个基准指针 k, 加上 slice[k:] 的头尾两端 i, j 两个指针
	for k := 0; k < len(nums)-1; k++ {
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
			this := nums[k] + nums[i] + nums[j]
			if abs(this-target) < abs(res-target) {
				res = this
			}
			if this == target {
				return res
			} else if this > target {
				j--
			} else {
				i++
			}
		}

	}
	return res
}

func main() {
	fmt.Println(threeSumClosest([]int{-1, 2, 1, -4}, 2))
	fmt.Println(threeSumClosest([]int{1, 1, 1, 0}, -100))
	fmt.Println(threeSumClosest([]int{1, 1, 1, 1}, 2))
}
