package main

import "testing"

func TestAddBinary(t *testing.T) {
	cases := map[string][]string{
		"case1": {"11", "1", "100"},
		"case2": {"1010", "1011", "10101"},
	}
	for _, v := range cases {
		in1, in2, except := v[0], v[1], v[2]

		if res := addBinary(in1, in2); res != except {
			t.Errorf("function(%v, %v): %v != %v", in1, in2, res, except)
		}
	}
}
