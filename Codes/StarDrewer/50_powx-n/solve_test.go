package main

import (
	"math"
	"testing"
)

func TestMyPow(t *testing.T) {
	cases := [][]interface{}{
		{0.0, 0},
		{0.0, 1},
		{1.0, 0},
		{2.0, 0},
		{2.0, 10},
		{2.1, 3},
		{2.0, -2},
		{0.0001, 2147483647},
	}

	for _, c := range cases {
		x, n := c[0].(float64), c[1].(int)
		if res, expect := myPow(x, n), math.Pow(x, float64(n)); res != expect {
			t.Errorf("function(%v, %v): result(%v) != espect(%v)", x, n, res, expect)
		}
	}
}

func TestMyPow1(t *testing.T) {
	cases := [][]interface{}{
		{0.0, 0},
		{0.0, 1},
		{1.0, 0},
		{2.0, 0},
		{2.0, 10},
		{2.1, 3},
		{2.0, -2},
		{0.0001, 2147483647},
	}

	for _, c := range cases {
		x, n := c[0].(float64), c[1].(int)
		if res, expect := myPow1(x, n), math.Pow(x, float64(n)); res != expect {
			t.Errorf("function(%v, %v): result(%v) != espect(%v)", x, n, res, expect)
		}
	}
}
