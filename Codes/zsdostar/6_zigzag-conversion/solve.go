package main

import "fmt"

// 题解: https://leetcode-cn.com/problems/zigzag-conversion/solution/bu-kuai-dan-te-wu-nao-de-yi-ge-jie-fa-_z_-by-zsdos/
func Min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
func convert(s string, numRows int) string {
	// 16 ms, 6.7 MB
	if len(s) < 2 || numRows < 2 {
		return s
	}
	div := numRows + (numRows - 2)

	// 将字符串按V字形来切分为数组
	divS := []string{}
	for i := 0; i < len(s); i += div {
		divS = append(divS, s[i:Min(i+div, len(s))])
	}
	// 将数组中每个元素的第一位取出
	res := ""
	for _, each := range divS {
		res += string(each[0])
	}

	// 使用i, j两个游标来从两端取值
	for i, j := 1, div-1; i <= j; i, j = i+1, j-1 {
		for _, each := range divS {
			if i < len(each) {
				res += string(each[i])
			}
			if j < len(each) && i != j {
				res += string(each[j])
			}
		}
	}
	return res
}
func main() {
	s := "LEETCODEISHIRING"
	n := 3
	fmt.Println(convert(s, n))
	fmt.Println(convert("A", 1))
	fmt.Println(convert("AB", 1))

}
