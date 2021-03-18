package main

func plusOne(digits []int) []int {
	tmp := 1
	for i := len(digits) - 1; i >= 0; i-- {
		if tmp != 0 {
			digits[i], tmp = (digits[i]+tmp)%10, (digits[i]+tmp)/10
		}
	}
	if tmp == 1 {
		digits = append([]int{1}, digits...)
	}
	return digits
}
