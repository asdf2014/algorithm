package main

import "fmt"

var numMap = map[int32]string{
	'2': "abc",
	'3': "def",
	'4': "ghi",
	'5': "jkl",
	'6': "mno",
	'7': "pqrs",
	'8': "tuv",
	'9': "wxyz",
}

func letterCombinations(digits string) []string {
	// 0 ms >100%, 2.7 MB >7.86%
	var res []string
	for _, eachNum := range digits {
		thisNum, ok := numMap[eachNum]
		if !ok {
			continue
		}
		// 初始化
		if len(res) == 0 {
			for _, v := range thisNum {
				res = append(res, string(v))
			}
		} else {
			// 将res队列已有字母，与新的数字对应的三个字母组合取值
			baseLen := len(res)
			for baseIndex := 0; baseIndex < baseLen; baseIndex++ {
				for _, newVal := range thisNum {
					res = append(res, res[baseIndex]+string(newVal))
				}
			}
			res = res[baseLen:]
		}
	}
	return res
}
func main() {
	fmt.Println(letterCombinations("23"))
	fmt.Println(letterCombinations("1112"))
}
