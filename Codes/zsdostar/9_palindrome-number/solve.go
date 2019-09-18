package main

import (
	"fmt"
)

func reverse(s string) string {
	// 36 ms, 6.1 MB
	// 翻转
	res := ""
	for i := len(s) - 1; i >= 0; i-- {
		res += string(s[i])
	}
	return res
}
func subCheck(s string) bool {
	// 24 ms, 5.4 MB
	// 头尾两个游标，模拟检查
	isP := true
	for i, j := 0, len(s)-1; i <= j; i, j = i+1, j-1 {
		if s[i] != s[j] {
			isP = false
			break
		}
	}
	return isP
}
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	strX := fmt.Sprintf("%d", x)
	return subCheck(strX)
}

func main() {
	fmt.Println(isPalindrome(10))
	fmt.Println(isPalindrome(1))
}
