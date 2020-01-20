package main

import "fmt"

func strStr(haystack string, needle string) int {
	lenString := len(haystack)
	lenSubString := len(needle)
	if lenSubString == 0 {
		return 0
	}
	for i := 0; i < lenString-lenSubString+1; i++ {
		for j := i; j < i+lenSubString; j++ {
			if haystack[j] != needle[j-i] {
				break
			}
			if j-i == lenSubString-1 {
				return i
			}
		}
	}
	return -1
}

func main() {
	h1, n1 := "hello", "ll"
	h2, n2 := "aaaaa", "bba"
	h3, n3 := "a", "a"
	h4, n4 := "aa", "aa"
	h5, n5 := "mississippi", "mississippi"
	fmt.Println(strStr(h1, n1) == 2, strStr(h1, n1))
	fmt.Println(strStr(h2, n2) == -1, strStr(h2, n2))
	fmt.Println(strStr(h3, n3) == 0, strStr(h3, n3))
	fmt.Println(strStr(h4, n4) == 0, strStr(h4, n4))
	fmt.Println(strStr(h5, n5) == 0, strStr(h5, n5))
}
