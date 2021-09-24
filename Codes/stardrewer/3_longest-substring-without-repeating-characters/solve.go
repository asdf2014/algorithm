package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	// 4~8 ms, 3.7 MB
	// 通过map来存储字符对应串上的下标
	// 可以适应中文等
	lastOccurred := make(map[rune]int)
	start := 0
	maxLength := 0
	for i, ch := range []rune(s) {
		if left, ok := lastOccurred[ch]; ok && left >= start {
			start = left + 1
		}
		if i-start+1 > maxLength {
			maxLength = i - start + 1
		}
		lastOccurred[ch] = i
	}
	return maxLength
}
func lengthOfLongestSubstringSpeed(s string) int {
	// 0~4 ms, 3 MB
	// 将HashMap换为长度为128的int数组, 0代表不存在, 所以下标从1开始
	// 仅适用于ascii
	lastOccurred := make([]int, 128)
	start := 0
	maxLength := 0
	for i, ch := range []byte(s) {
		if left := lastOccurred[ch]; left >= start {
			start = left
		}
		if i-start+1 > maxLength {
			maxLength = i - start + 1
		}
		lastOccurred[ch] = i + 1
	}
	return maxLength
}
func main() {
	testCase := []string{"abcabcbb", "bbbbb", "pwwkew"}
	for _, v := range testCase {
		fmt.Println(lengthOfLongestSubstring(v), lengthOfLongestSubstringSpeed(v))
	}
}
