package main

import "testing"

func TestMaxSubArray(t *testing.T) {
	cases := [][]interface{}{
		{[]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
	}

	for _, c := range cases {
		in, expect := c[0].([]int), c[1].(int)

		if res := maxSubArray(in); res != expect {
			t.Errorf("function(%v): %v != %v", in, res, expect)
		}
	}
}
