package main

import "fmt"

func searchInsert(nums []int, target int) int {
	for k, v := range nums {
		if target <= v {
			return k
		}
	}
	return len(nums)
}

func main() {
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 5) == 2)
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 7) == 4)
}
