//Given an array of strings words and a width maxWidth, format the text such
//that each line has exactly maxWidth characters and is fully (left and right)
//justified.
//
// You should pack your words in a greedy approach; that is, pack as many words
//as you can in each line. Pad extra spaces ' ' when necessary so that each line
//has exactly maxWidth characters.
//
// Extra spaces between words should be distributed as evenly as possible. If
//the number of spaces on a line does not divide evenly between words, the empty
//slots on the left will be assigned more spaces than the slots on the right.
//
// For the last line of text, it should be left-justified and no extra space is
//inserted between words.
//
// Note:
//
//
// A word is defined as a character sequence consisting of non-space characters
//only.
// Each word's length is guaranteed to be greater than 0 and not exceed
//maxWidth.
// The input array words contains at least one word.
//
//
//
// Example 1:
//
//
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
//, maxWidth = 16
//Output:
//[
// "This  is  an",
// "example of text",
// "justification. "
//]
//
// Example 2:
//
//
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
//16
//Output:
//[
// "What  must  be",
// "acknowledgment ",
// "shall be    "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall
//be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified becase it contains only one
//word.
//
// Example 3:
//
//
//Input: words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"],
//maxWidth = 20
//Output:
//[
// "Science is what we",
//  "understand   well",
// "enough to explain to",
// "a computer. Art is",
// "everything else we",
// "do         "
//]
//
//
// Constraints:
//
//
// 1 <= words.length <= 300
// 1 <= words[i].length <= 20
// words[i] consists of only English letters and symbols.
// 1 <= maxWidth <= 100
// words[i].length <= maxWidth
//
// Related Topics 字符串 模拟 👍 181 👎 0

package main

import (
	"fmt"
	"strings"
)

//leetcode submit region begin(Prohibit modification and deletion)
type Matrix struct {
	Lines      []Line
	MaxWidth   int
	FormatChar string
}

func (matrix *Matrix) Append(val string) {
	if len(matrix.Lines) == 0 {
		matrix.Lines = append(matrix.Lines, Line{MaxWidth: matrix.MaxWidth, FormatChar: matrix.FormatChar})
	}
	if ok := matrix.Lines[len(matrix.Lines)-1].Append(val); !ok {
		matrix.Lines = append(matrix.Lines, Line{MaxWidth: matrix.MaxWidth, FormatChar: matrix.FormatChar})
		matrix.Lines[len(matrix.Lines)-1].Append(val)
	}
}

func (matrix *Matrix) Format() (res []string) {
	for i := 0; i < len(matrix.Lines); i++ {
		if i == len(matrix.Lines)-1 {
			res = append(res, matrix.Lines[i].Format(true))
		} else {
			res = append(res, matrix.Lines[i].Format(false))
		}
	}
	return
}

type Line struct {
	Total      int
	MaxWidth   int
	Words      []string
	FormatChar string
}

func (l *Line) Append(val string) bool {
	if l.Total == 0 {
		l.Words = append(l.Words, val)
		l.Total += len(val)
		return true
	}
	if l.Total+len(val)+1 > l.MaxWidth {
		return false
	}
	l.Words = append(l.Words, val)
	l.Total += len(val) + 1
	return true
}

func (l *Line) Format(isEnd bool) (res string) {
	if isEnd || len(l.Words) == 1 {
		res += strings.Join(l.Words, l.FormatChar)
		for i := 0; i < l.MaxWidth-l.Total; i++ {
			res += l.FormatChar
		}
		return
	} else if len(l.Words) == 2 {
		for i := 0; i < l.MaxWidth-l.Total; i++ {
			l.Words[0] += l.FormatChar
		}
		res += strings.Join(l.Words, l.FormatChar)
		return
	} else {
		// TODO should deep copy l.Words
		for i := 0; i < l.MaxWidth-l.Total; i++ {
			l.Words[i%(len(l.Words)-1)] += l.FormatChar
		}
		res += strings.Join(l.Words, l.FormatChar)
		return
	}
}

func fullJustify(words []string, maxWidth int) []string {
	matrix := Matrix{MaxWidth: maxWidth, FormatChar: " "}
	for i := 0; i < len(words); i++ {
		matrix.Append(words[i])
	}
	return matrix.Format()
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	for _, v := range fullJustify([]string{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20) {
		fmt.Println(v)
	}
	fmt.Println()

	for _, v := range fullJustify([]string{"This", "is", "an", "example", "of", "text", "justification."}, 16) {
		fmt.Println(v)
	}
	fmt.Println()

	for _, v := range fullJustify([]string{"What", "must", "be", "acknowledgment", "shall", "be"}, 16) {
		fmt.Println(v)
	}
	fmt.Println()

	for _, v := range fullJustify([]string{"Science", "is", "what", "we", "understand", "well", "enough", "to",
		"explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20) {
		fmt.Println(v)
	}
	fmt.Println()

	for _, v := range fullJustify([]string{"a"}, 20) {
		fmt.Println(v)
	}
	fmt.Println()
}
