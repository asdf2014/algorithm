package main

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	sum := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i-1] > 0 {
			nums[i] += nums[i-1]
		}
		sum = max(nums[i], sum)
	}
	return sum
}
