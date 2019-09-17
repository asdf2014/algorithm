package main

import (
	"fmt"
	"math"
)

var ascii = map[int32]int{
	'0': 0,
	'1': 1,
	'2': 2,
	'3': 3,
	'4': 4,
	'5': 5,
	'6': 6,
	'7': 7,
	'8': 8,
	'9': 9,
}

func myAtoi(str string) int {
	// 4 ms, 2.3 MB
	signed := ""
	temp, res := "", 0
	// 死抠细节, 变态的数据。。
	for _, v := range str {
		if (v == ' ' || v == '-' || v == '+') && (len(temp) > 0 || signed != "") {
			break
		}
		switch v {
		case ' ':
			continue
		case '-':
			signed = "-"
			continue
		case '+':
			signed = "+"
			continue
		}
		if _, ok := ascii[v]; !ok {
			break
		}
		temp += string(v)
	}
	// temp已经成为干净的数字字符串，只需按位转为int即可
	for k, v := range temp {
		res += int(float64(ascii[v]) * math.Pow(10.0, float64(len(temp)-k-1)))
	}
	if signed == "-" {
		res = -res
	}
	// 注意太大值溢出变为负数的问题
	max, min := math.MaxInt32, -(math.MaxInt32 + 1)
	if res > max {
		res = max
		if signed == "-" {
			res = min
		}
	} else {
		if res < min {
			res = min
			if signed != "-" {
				res = max
			}
		}
	}

	return res
}

func main() {
	fmt.Println(myAtoi("2147483648"))
	fmt.Println(myAtoi("20000000000000000000"))
	fmt.Println(myAtoi("   +0 123")) // 0
	fmt.Println(myAtoi("+-2"))       // 0
	fmt.Println(myAtoi("42"))
	fmt.Println(myAtoi("   -42"))
	fmt.Println(myAtoi("4193 with words"))
	fmt.Println(myAtoi("  --4193 with words"))
	fmt.Println(myAtoi("words and 987"))
	fmt.Println(myAtoi("-91283472332"))
}
