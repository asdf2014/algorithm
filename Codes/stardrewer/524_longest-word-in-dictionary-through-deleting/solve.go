//Given a string s and a string array dictionary, return the longest string in
//the dictionary that can be formed by deleting some of the given string
//characters. If there is more than one possible result, return the longest word with the
//smallest lexicographical order. If there is no possible result, return the empty
//string.
//
//
// Example 1:
//
//
//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//Output: "apple"
//
//
// Example 2:
//
//
//Input: s = "abpcplea", dictionary = ["a","b","c"]
//Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s and dictionary[i] consist of lowercase English letters.
//
// Related Topics 数组 双指针 字符串 排序 👍 243 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)

func findLongestWord(s1 string, dictionary []string) string {
	lenS1 := len(s1)
	min := ""
	longest := 0
	for _, s2 := range dictionary {
		lenS2 := len(s2)
		if isContain(s1, s2, lenS1, lenS2) {
			if min == "" || lenS2 > longest || lenS2 == longest && s2 < min {
				min = s2
				longest = lenS2
			}
		}
	}

	return min
}

func isContain(s1, s2 string, lenS1, lenS2 int) bool {
	for i, j := 0, 0; i < lenS1 && j < lenS2; {
		if s1[i] == s2[j] {
			i++
			j++
		} else {
			i++
		}
		if j == lenS2 {
			return true
		}
	}
	return false
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(findLongestWord("abpcplea", []string{"ale", "apple", "monkey", "plea"}))
	fmt.Println(findLongestWord("abpcplea", []string{"a", "b", "c"}))
	fmt.Println(findLongestWord("abpcplea", []string{"c", "b", "a"}))
	fmt.Println(findLongestWord("a", []string{"b", "c"}))
	fmt.Println(findLongestWord("a", []string{"c", "a"}))
}
