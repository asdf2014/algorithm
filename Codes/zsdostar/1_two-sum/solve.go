package main

import "fmt"

func twoSum(nums []int, target int) []int {
	// 8 ms, 4.1 MB
	// 将数组加载到HashMap
	numsHashMap := make(map[int]int)
	for k, v := range nums {
		// 重复元素特殊处理
		if v == target-v {
			if x, ok := numsHashMap[v]; ok {
				return []int{x, k}
			}
		}
		numsHashMap[v] = k
	}

	// 对于数组的每一个元素v，检查target-v是否在HashMap内
	for k, v := range nums {
		if v == target-v {
			continue
		}
		if x, ok := numsHashMap[target-v]; ok {
			return []int{k, x}
		}
	}
	return nil
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
	fmt.Println(twoSum([]int{1, 1, 3, 1, 3}, 6))
	fmt.Println(twoSum([]int{3, 2, 4}, 6))
	fmt.Println(twoSum([]int{-1, -2, -3, -4, -5}, -8))
}
