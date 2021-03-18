package main

//反向顺序解法 + 双层循环更容易 debug, 双指针太容易出错了...
func lengthOfLastWord(s string) int {
	n := len(s) - 1
	res := 0

	for j := n; j >= 0; j-- {
		if s[j] != ' ' {
			for i := j; i >= 0; i-- {
				if s[i] == ' ' {
					res = len(s[i+1 : j+1])
					break
				}
				if i == 0 {
					res = len(s[i : j+1])
					break
				}
			}
			break
		}
	}
	return res
}

//这是正向顺序解法
func lengthOfLastWord1(s string) int {
	res := 0
	if len(s) == 1 && s != " " {
		return 1
	}
	for i, j := 0, 0; j <= len(s); j++ {
		if (j != len(s) && s[j] == ' ') || j == len(s) {
			if j != 0 && s[j-1] != ' ' {
				res = len(s[i:j])
			}
			i = j + 1
		}
	}
	return res
}
