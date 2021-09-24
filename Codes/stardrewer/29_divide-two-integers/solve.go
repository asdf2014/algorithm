package main

import "fmt"

func divide(dividend int, divisor int) int {
	var res int

	signed := 1

	if dividend < 0 {
		signed = -signed
		dividend = -dividend
	}
	if divisor < 0 {
		signed = -signed
		divisor = -divisor
	}
	if divisor == 1 {
		res = dividend
	} else {
		for dividend >= divisor && dividend != 0 {
			dividend -= divisor
			res++
		}
	}

	if signed < 0 {
		if -res < -2<<30 {
			return 2<<30 - 1
		}
		return -res
	}
	if res > 2<<30-1 {
		return 2<<30 - 1
	}
	return res
}

func main() {
	if a, b, res := 10, 3, divide(10, 3); res != a/b {
		fmt.Printf("error: divide(%v, %v) != %v, the res is %v\n", a, b, a/b, res)
	}
	if a, b, res := 7, -3, divide(7, -3); res != a/b {
		fmt.Printf("error: divide(%v, %v) != %v, the res is %v\n", a, b, a/b, res)
	}
	if a, b, res := 1, 1, divide(1, 1); res != a/b {
		fmt.Printf("error: divide(%v, %v) != %v, the res is %v\n", a, b, a/b, res)
	}
	if a, b, res := -2147483648, -1, divide(-2147483648, -1); res != a/b {
		fmt.Printf("error: divide(%v, %v) != %v, the res is %v\n", a, b, a/b, res)
	}
	if a, b, res := -2147483648, 2, divide(-2147483648, 2); res != a/b {
		fmt.Printf("error: divide(%v, %v) != %v, the res is %v\n", a, b, a/b, res)
	}
}
