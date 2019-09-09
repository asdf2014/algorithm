package main

import "fmt"

func fib(N int) int {
	// 0 ms, 1.9 MB
	// 递推法求斐波那契
	if N == 0 {
		return 0
	}
	n1, n2 := 0, 1 // n1为n-1，n2为n-2
	for i := 1; i < N; i++ {
		n1, n2 = n1+n2, n1
	}
	return n1 + n2
}

func main() {
	for i := 0; i < 10; i++ {
		fmt.Printf("%d ", fib(i))
	}
}
