package main

import "fmt"

var cache = []int{0, 1}

func fib(n int) int {
	if n < len(cache) {
		return cache[n]
	}
	var tmp int
	for i := len(cache); i <= n; i++ {
		tmp = cache[i-1] + cache[i-2]
		if tmp > 1e9 {
			tmp %= (1e9 + 7)
		}
		cache = append(cache, tmp)
	}
	return cache[n]
}

func main() {
	fmt.Println(fib(100))
}
