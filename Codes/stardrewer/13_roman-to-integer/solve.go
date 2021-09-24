package main

import "fmt"

var romanMap = map[string]int{
	"MMM":  3000,
	"MM":   2000,
	"M":    1000,
	"CM":   900,
	"DCCC": 800,
	"DCC":  700,
	"DC":   600,
	"D":    500,
	"CD":   400,
	"CCC":  300,
	"CC":   200,
	"C":    100,
	"XC":   90,
	"LXXX": 80,
	"LXX":  70,
	"LX":   60,
	"L":    50,
	"XL":   40,
	"XXX":  30,
	"XX":   20,
	"X":    10,
	"IX":   9,
	"VIII": 8,
	"VII":  7,
	"VI":   6,
	"V":    5,
	"IV":   4,
	"III":  3,
	"II":   2,
	"I":    1,
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func romanToInt(s string) int {
	var resSlice []int
	var res int
	for i := 0; i < len(s); {
		t := min(i+4, len(s))
		for t > 0 {
			if temp, ok := romanMap[s[i:t]]; ok {
				resSlice = append(resSlice, temp)
				break
			} else {
				t--
			}
		}
		i = t
	}
	for _, v := range resSlice {
		res += v
	}
	return res
}
func main() {
	fmt.Println(romanToInt("III"))
	fmt.Println(romanToInt("IV"))
	fmt.Println(romanToInt("IX"))
	fmt.Println(romanToInt("LVIII"))
	fmt.Println(romanToInt("MCMXCIV"))
}
