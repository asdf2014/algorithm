package main

import (
	"fmt"
	"math"
)

func minSubLen(strs []string) int {
	// 最短的串的长度，超过肯定没有公共前缀
	min := math.MaxInt32
	if len(strs) == 0 {
		min = 0
	}
	for _, v := range strs {
		if len(v) < min {
			min = len(v)
		}
	}
	return min
}
func longestCommonPrefix(strs []string) string {
	// 4 ms, 2.5 MB
	var res string
	for i, toContinue := 0, true; i < minSubLen(strs) && toContinue; i++ {
		base := ""
		for k, v := range strs {
			// 最短
			if i >= len(v) {
				toContinue = false
				break
			}
			// 初始化
			if base == "" {
				base = string(v[i])
			} else {
				// 检查匹配性
				if base != string(v[i]) {
					toContinue = false
					break
				}
			}
			// 全部匹配则输出到res
			if k == len(strs)-1 {
				res += base
			}
		}
	}
	return res
}
func main() {
	//fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
	//fmt.Println(longestCommonPrefix([]string{"aa","a"}))
	//fmt.Println(longestCommonPrefix([]string{"", "a"}))
	//fmt.Println(longestCommonPrefix([]string{"dog","racecar","car"}))
	fmt.Println(longestCommonPrefix([]string{}))
}
