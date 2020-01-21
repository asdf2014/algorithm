package main

import "testing"

func TestLengthOfLastWord(t *testing.T) {
	cases := [][]interface{}{
		{"Hello World", 5},
		{"   Hello World  s  ", 1},
		{"   Hello World    ", 5},
		{"a", 1},
		{"aaaaaa", 6},
		{" a", 1},
		{"a ", 1},
		{" ", 0},
		{"  ", 0},
	}

	for _, c := range cases {
		in, esp := c[0].(string), c[1].(int)

		if res := lengthOfLastWord(in); res != esp {
			t.Errorf("function(%v): %v != %v", in, res, esp)
		}
	}
}
func TestLengthOfLastWord1(t *testing.T) {
	cases := [][]interface{}{
		{"Hello World", 5},
		{"   Hello World  s  ", 1},
		{"   Hello World    ", 5},
		{"a", 1},
		{"aaaaaa", 6},
		{" a", 1},
		{"a ", 1},
		{" ", 0},
		{"  ", 0},
	}

	for _, c := range cases {
		in, esp := c[0].(string), c[1].(int)

		if res := lengthOfLastWord1(in); res != esp {
			t.Errorf("function(%v): %v != %v", in, res, esp)
		}
	}
}
