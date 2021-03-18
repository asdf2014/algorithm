package main

import "fmt"

func min(a, b int) int {
	if a <= b {
		return a
	}
	return b
}
func minCostToMoveChips(chips []int) int {
	even, odd := 0, 0
	for _, v := range chips {
		if v%2 == 1 {
			even++
		} else {
			odd++
		}
	}
	return min(even, odd)

}
func main() {
	fmt.Println(minCostToMoveChips([]int{1, 2, 3}) == 1)
	fmt.Println(minCostToMoveChips([]int{2, 2, 2, 3, 3}) == 2)
	fmt.Println(minCostToMoveChips([]int{1, 2, 2, 2, 2}) == 1)
}
