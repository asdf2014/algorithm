package main

import "fmt"

func calcMaxLenSub(maxLen *int, maxSub *string, l, r int, s string) {

	for l >= 0 && r < len(s) && s[l] == s[r] {
		thisSub := s[l : r+1]
		if len(thisSub) > *maxLen {
			*maxSub = thisSub
			*maxLen = len(*maxSub)
		}
		l--
		r++
	}
}
func longestPalindrome(s string) string {
	// 20 ms, 2.3 MB -> 12 ms, 2.3MB
	maxLen, maxSub := 0, ""
	for i := range s {
		calcMaxLenSub(&maxLen, &maxSub, i, i, s)
		calcMaxLenSub(&maxLen, &maxSub, i, i+1, s)
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
