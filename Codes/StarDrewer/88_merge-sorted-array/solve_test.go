package main

import (
	"reflect"
	"testing"
)

func TestMerge(t *testing.T) {
	inA1, inB1, inC1, inD1 := []int{1, 2, 3, 0, 0, 0}, 3, []int{2, 5, 6}, 3
	merge(inA1, inB1, inC1, inD1)
	if except := []int{1, 2, 2, 3, 5, 6}; !reflect.DeepEqual(inA1, except) {
		t.Errorf("function(%v, %v): %v != %v", []int{1, 2, 3, 0, 0, 0}, []int{2, 5, 6}, inA1, except)
	}

	inA2, inB2, inC2, inD2 := []int{4, 5, 6, 0, 0, 0}, 3, []int{1, 2, 3}, 3
	merge(inA2, inB2, inC2, inD2)
	if except := []int{1, 2, 3, 4, 5, 6}; !reflect.DeepEqual(inA2, except) {
		t.Errorf("function(%v, %v): %v != %v", []int{4, 5, 6, 0, 0, 0}, []int{1, 2, 3}, inA1, except)
	}
}
