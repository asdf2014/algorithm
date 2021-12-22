package main

import (
	"fmt"
	"sort"
)

func sumInt(cards []int) int {
	sum := 0
	for i := 0; i < (len(cards)); i++ {
		sum += cards[i]
	}
	return sum
}

func find(src []int, min bool, odd bool) int {
	if min {
		for i := 0; i < len(src); i++ {
			if odd {
				if src[i]%2 == 1 {
					return src[i]
				}
			} else {
				if src[i]%2 == 0 {
					return src[i]
				}
			}
		}
	} else {
		for i := len(src) - 1; i >= 0; i-- {
			if odd {
				if src[i]%2 == 1 {
					return src[i]
				}
			} else {
				if src[i]%2 == 0 {
					return src[i]
				}
			}
		}
	}
	return -1
}

func maxmiumScore(cards []int, cnt int) int {
	sort.Ints(cards)
	tmp := cards[len(cards)-cnt:]
	sum := sumInt(tmp)
	if sum%2 == 0 {
		return sum
	} else {
		x1 := find(tmp, true, true)
		y1 := find(cards[:len(cards)-cnt], false, false)
		x2 := find(tmp, true, false)
		y2 := find(cards[:len(cards)-cnt], false, true)
		if x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1 {
			sum1 := sum - x1 + y1
			sum2 := sum - x2 + y2
			if sum1 > sum2 {
				return sum1
			}
			return sum2
		}
		if x1 != -1 && y1 != -1 {
			return sum - x1 + y1
		} else {
			if x2 != -1 && y2 != -1 {
				return sum - x2 + y2
			} else {
				return 0
			}
		}
	}
}

func main() {
	fmt.Println(maxmiumScore([]int{1, 2, 3, 4, 5}, 2))
}
