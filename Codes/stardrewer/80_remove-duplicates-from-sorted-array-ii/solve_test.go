package main

import (
	"reflect"
	"testing"
)

func TestRemoveDuplicates(t *testing.T) {
	cases := [][]interface{}{
		{[]int{}, 0, []int{}},
		{[]int{1}, 1, []int{1}},
		{[]int{1, 1}, 2, []int{1, 1}},
		{[]int{1, 2}, 2, []int{1, 2}},
		{[]int{1, 2, 3}, 3, []int{1, 2, 3}},
		{[]int{1, 1, 1, 2, 2, 3}, 5, []int{1, 1, 2, 2, 3}},
		{[]int{0, 0, 1, 1, 1, 1, 2, 3, 3}, 7, []int{0, 0, 1, 1, 2, 3, 3}},
	}

	for _, c := range cases {
		in, espInt, espSlice := c[0].([]int), c[1].(int), c[2].([]int)

		if res := removeDuplicates(in); !(res == espInt && reflect.DeepEqual(in[:res], espSlice)) {
			t.Errorf("function(%v): %v != %v or %v != %v", in, res, espInt, in[:res], espSlice)
		}
	}

}
