package main

import "fmt"

var cache = []int{0, 1, 2}

func climbStairs(n int) int {
	if n < len(cache) {
		return cache[n]
	}
	for i := len(cache); i <= n; i++ {
		cache = append(cache, cache[i-1]+cache[i-2])
	}
	return cache[n]
}

func main() {
	fmt.Println(climbStairs(5))
}
