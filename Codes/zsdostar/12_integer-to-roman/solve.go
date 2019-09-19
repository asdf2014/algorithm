package main

import (
	"fmt"
	"math"
)

var romanMap = map[int]string{
	3000: "MMM",
	2000: "MM",
	1000: "M",
	900:  "CM",
	800:  "DCCC",
	700:  "DCC",
	600:  "DC",
	500:  "D",
	400:  "CD",
	300:  "CCC",
	200:  "CC",
	100:  "C",
	90:   "XC",
	80:   "LXXX",
	70:   "LXX",
	60:   "LX",
	50:   "L",
	40:   "XL",
	30:   "XXX",
	20:   "XX",
	10:   "X",
	9:    "IX",
	8:    "VIII",
	7:    "VII",
	6:    "VI",
	5:    "V",
	4:    "IV",
	3:    "III",
	2:    "II",
	1:    "I",
}

func intToRoman(num int) string {
	var temp []int
	var res string
	// 将整数每位拆解
	for i := 0; num > 0; i++ {
		temp = append(temp, (num%10)*int(math.Pow10(i)))
		num /= 10
	}
	// 从大数到小数的顺序，输出罗马字
	for i := len(temp) - 1; i >= 0; i-- {
		res += romanMap[temp[i]]
	}
	return res
}
func main() {
	fmt.Println(intToRoman(3))
	fmt.Println(intToRoman(4))
	fmt.Println(intToRoman(9))
	fmt.Println(intToRoman(58))
	fmt.Println(intToRoman(1994))
}
