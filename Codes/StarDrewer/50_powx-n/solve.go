package main

//O(logn) 快速幂
func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}

	if n < 0 {
		x = 1 / x
		n = -n
	}

	var res float64 = 1
	current := x
	for i := n; i != 0; i /= 2 {
		if i%2 == 1 {
			res = res * current
		}
		current = current * current
	}

	return res
}

//O(n) 解法
//害...TLE
func myPow1(x float64, n int) float64 {
	if n == 0 {
		return 1
	}

	if n < 0 {
		x = 1.0 / x
		n = -n
	}
	res := x
	for i := 1; i < n; i++ {
		res *= x
	}

	return res
}
