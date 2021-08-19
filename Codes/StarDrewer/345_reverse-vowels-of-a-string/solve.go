package main

var vowels = map[byte]struct{}{
	'a': {},
	'e': {},
	'i': {},
	'o': {},
	'u': {},
	'A': {},
	'E': {},
	'I': {},
	'O': {},
	'U': {},
}
var tmp byte

func reverseVowels(origin string) string {
	s := []byte(origin)
	head, tail := 0, len(s)-1

	for head < tail {
		if _, ok := vowels[s[head]]; !ok {
			head++
			continue
		}
		if _, ok := vowels[s[tail]]; !ok {
			tail--
			continue
		}
		tmp = s[head]
		s[head] = s[tail]
		s[tail] = tmp
		head++
		tail--
	}
	return string(s)
}

func main() {
	fmt.Println(reverseVowels("hello"))
	fmt.Println(reverseVowels("leetcode"))
}
