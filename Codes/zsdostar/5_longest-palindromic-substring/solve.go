package main

import "fmt"

func updateLR(l, r *int, i, move int, moveType int) {
	// moveType为0则以两个元素的中间为中心点，否则以元素下标为中心点
	// 从而计算出向左或向右查找的下标
	if moveType == 0 {
		*l, *r = i-move+1, i+move
	} else {
		*l, *r = i-move, i+move
	}
}
func _solve(maxLen *int, maxSub *string, i, moveType int, s string) {
	move := 1
	var moveLeft, moveRight int
	updateLR(&moveLeft, &moveRight, i, move, moveType)

	for moveLeft >= 0 && moveRight < len(s) {
		if s[moveLeft] == s[moveRight] {
			thisSub := s[moveLeft : moveRight+1]
			if len(thisSub) > *maxLen {
				*maxSub = s[moveLeft : moveRight+1]
				*maxLen = len(*maxSub)
			}
			move++
			updateLR(&moveLeft, &moveRight, i, move, moveType)
		} else {
			break
		}
	}
}
func longestPalindrome(s string) string {
	// 20 ms, 2.3 MB
	maxLen, maxSub := 0, ""
	for i := range s {
		_solve(&maxLen, &maxSub, i, 0, s)
		_solve(&maxLen, &maxSub, i, 1, s)
	}
	if maxLen == 0 && len(s) > 0 {
		maxLen, maxSub = 1, string(s[0])
	}
	return maxSub
}

func main() {
	fmt.Println(longestPalindrome("ccc"))   // ccc
	fmt.Println(longestPalindrome("abb"))   // bb
	fmt.Println(longestPalindrome("bb"))    // bb
	fmt.Println(longestPalindrome("babad")) // bab
	fmt.Println(longestPalindrome("cbbd"))  // bb
	fmt.Println(longestPalindrome("a"))     // a
	fmt.Println(longestPalindrome(""))      // ""
}
