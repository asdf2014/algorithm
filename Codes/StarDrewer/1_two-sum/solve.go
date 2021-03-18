package main

import "fmt"

func twoSum(nums []int, target int) []int {
	// 8 ms, 4.1 MB -> 4 ms, 3.8 MB
	numsHashMap := make(map[int]int)

	// 对于数组的每一个元素v，检查target-v是否在HashMap内
	// 参考排名前列的答案，将先加载到哈希然后判断，合成为1步，简直神来之笔
	for k, v := range nums {
		if x, ok := numsHashMap[target-v]; ok {
			return []int{k, x}
		}
		numsHashMap[v] = k
	}
	return nil
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
	fmt.Println(twoSum([]int{1, 1, 3, 1, 3}, 6))
	fmt.Println(twoSum([]int{3, 2, 4}, 6))
	fmt.Println(twoSum([]int{-1, -2, -3, -4, -5}, -8))
}
