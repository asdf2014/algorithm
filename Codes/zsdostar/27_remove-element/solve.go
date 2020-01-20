package main

import "fmt"

func removeElement(nums []int, val int) int {

	for i := 0; i < len(nums); {
		if nums[i] == val {
			nums = append(nums[:i], nums[i+1:]...)
		} else {
			i++
		}
	}
	return len(nums)
}
func main() {
	i1, val1 := []int{1, 2, 2, 1}, 1
	fmt.Println(i1[:removeElement(i1, val1)])

	i2, val2 := []int{0, 1, 2, 2, 3, 0, 4, 2}, 2
	fmt.Println(i2[:removeElement(i2, val2)])
}
