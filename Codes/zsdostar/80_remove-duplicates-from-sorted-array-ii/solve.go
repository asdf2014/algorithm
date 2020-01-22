package main

func removeDuplicates(nums []int) int {
	var res int
	if len(nums) <= 1 {
		res = len(nums)
	}
	//双指针,i为存储计算结果,j为读取输入
	for i, j := 1, 1; j < len(nums); {
		//最后一位直接跳出
		if j == len(nums)-1 {
			nums[i] = nums[j]
			res = i + 1
			break
		}
		//如果j的左右值相等,就跳过
		if nums[j-1] == nums[j+1] {
			j++
			continue
		}
		nums[i] = nums[j]
		i++
		j++
	}
	return res
}
