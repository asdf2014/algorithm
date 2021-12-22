package main

import (
	"reflect"
	"testing"
)

func TestPlusOne(t *testing.T) {
	cases := [][][]int{
		{[]int{0}, []int{1}},
		{[]int{1}, []int{2}},
		{[]int{9}, []int{1, 0}},
		{[]int{9, 9, 9}, []int{1, 0, 0, 0}},
		{[]int{1, 2, 3}, []int{1, 2, 4}},
		{[]int{4, 3, 2, 1}, []int{4, 3, 2, 2}},
	}

	for _, c := range cases {
		in, expect := c[0], c[1]

		if res := plusOne(in); !reflect.DeepEqual(res, expect) {
			t.Errorf("function(%v): %v != %v", in, res, expect)
		}
	}
}
