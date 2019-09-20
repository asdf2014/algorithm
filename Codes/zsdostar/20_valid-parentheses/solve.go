package main

import "fmt"

var parentheses = map[rune]rune{
	'(': ')',
	'{': '}',
	'[': ']',
}

func isNull(stack *[]rune) bool {
	return len(*stack) == 0
}
func head(stack *[]rune) rune {
	// 栈顶
	var res rune
	if !isNull(stack) {
		res = (*stack)[len(*stack)-1]
	}
	return res
}
func pop(stack *[]rune) rune {
	// 出栈
	h := head(stack)
	*stack = (*stack)[:len(*stack)-1]
	return h
}

func isValid(s string) bool {
	// 0 ms >100.00%, 2.1 MB >52.72%
	var stack []rune
	for _, v := range s {
		switch {
		case v == ' ':
			continue
		case v == '(' || v == '{' || v == '[':
			stack = append(stack, v)
		case v == ')' || v == '}' || v == ']':
			if v == parentheses[head(&stack)] {
				pop(&stack)
			} else {
				stack = append(stack, v)
				break
			}
		}

	}
	return len(stack) == 0
}
func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("(]"))
	fmt.Println(isValid("([)]"))
	fmt.Println(isValid("{[]}"))
	fmt.Println(isValid(")"))
	fmt.Println(isValid(""))
}
