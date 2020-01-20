package main

import "fmt"

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	index := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			nums[index] = nums[i]
			index++
		}

	}
	return index
}

func main() {
	var i0 []int
	fmt.Println(i0[:removeDuplicates(i0)])

	i1 := []int{1, 1, 2}
	fmt.Println(i1[:removeDuplicates(i1)])

	i2 := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	fmt.Println(i2[:removeDuplicates(i2)])

	i4 := []int{1}
	fmt.Println(i4[:removeDuplicates(i4)])

	i5 := []int{1, 1}
	fmt.Println(i5[:removeDuplicates(i5)])
}
