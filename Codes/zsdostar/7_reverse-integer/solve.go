package main

import (
	"fmt"
	"math"
)

func reverse(x int) int {
	// 4 ms, 2.3 MB
	signed := false
	if x < 0 {
		signed = true
		x = -x
	}

	res := 0
	resList := []int{}
	for x > 0 {
		resList = append(resList, x%10)
		x = x / 10
	}
	for k, v := range resList {
		res += int(float64(v) * math.Pow(10.0, float64(len(resList)-k-1)))
	}

	if signed {
		res = -res
	}
	if res >= math.MaxInt32 || res <= -(math.MaxInt32+1) {
		res = 0
	}
	return res
}

func main() {
	fmt.Println(reverse(12012440))
	fmt.Println(reverse(123))
	fmt.Println(reverse(848113131414153515))
}
