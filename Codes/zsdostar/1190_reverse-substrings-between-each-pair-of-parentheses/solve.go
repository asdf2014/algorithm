package main

import "fmt"

func reverseString(s string) string {
	runes := []rune(s)
	for from, to := 0, len(runes)-1; from < to; from, to = from+1, to-1 {
		runes[from], runes[to] = runes[to], runes[from]
	}
	return string(runes)
}
func reverseParentheses(s string) string {
	// 0 ms >100%, 2.2 MB >100%
	var stack []string
	var res string
	for _, v := range s {
		switch v {
		case '(':
			stack = append(stack, "")
		case ')':
			if len(stack) == 0 {
				break
			}
			// -1位反转
			stack[len(stack)-1] = reverseString(stack[len(stack)-1])
			if len(stack) > 1 {
				// -1位拼接到-2位
				stack[len(stack)-2] += stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
		default:
			if len(stack) == 0 {
				stack = append(stack, "")
			}
			stack[len(stack)-1] += string(v)
		}
	}
	if len(stack) > 0 {
		res = stack[0]
	}

	return res
}
func main() {
	fmt.Println(reverseParentheses("ta()usw((((a))))"))
	fmt.Println(reverseParentheses("co(de(fight)s)"))
	fmt.Println(reverseParentheses("(abcd)"))
	fmt.Println(reverseParentheses("(u(love)i)"))
	fmt.Println(reverseParentheses("(ed(et(oc))el)"))
	fmt.Println(reverseParentheses("a(bcdefghijkl(mno)p)q"))
	fmt.Println(reverseParentheses(""))

}
