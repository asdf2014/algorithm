package main

import (
	"fmt"
	"sort"
)

func nextPermutation(nums []int) {
	i := len(nums) - 1

	breakFlag := false
	for ; i >= 0; i-- {

		for j := len(nums) - 1; j > i; j-- {
			if nums[j] > nums[i] {
				tmp := nums[j]
				nums[j] = nums[i]
				nums[i] = tmp
				breakFlag = true
				break
			}
		}
		if breakFlag == true {
			break
		}

	}
	sort.Sort(sort.IntSlice(nums[i+1:]))
}

func main() {
	var a0 []int
	nextPermutation(a0)
	fmt.Println(a0)

	a1 := [3]int{1, 2, 3}
	nextPermutation(a1[:])
	fmt.Println(a1, a1 == [3]int{1, 3, 2})

	a2 := [3]int{3, 2, 1}
	nextPermutation(a2[:])
	fmt.Println(a2, a2 == [3]int{1, 2, 3})

	a3 := [3]int{1, 1, 5}
	nextPermutation(a3[:])
	fmt.Println(a3, a3 == [3]int{1, 5, 1})

	a4 := [3]int{1, 3, 2}
	nextPermutation(a4[:])
	fmt.Println(a4, a4 == [3]int{2, 1, 3})

	a5 := [4]int{2, 3, 1, 0}
	nextPermutation(a5[:])
	fmt.Println(a5, a5 == [4]int{3, 0, 1, 2})

}
