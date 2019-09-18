package main

import "fmt"

func mergeTwoSortedArray(nums1, nums2 *[]int) []int {
	// 20 ms, 6.2 MB
	// 最多只能写到 O(m+n) 了
	// 再优化可以到 O((m+n)/2) 但是代码结构会乱掉啊_(:зゝ∠)_, 或者用生成器勉强不会乱但是太麻烦了
	// 至于O(log(m+n)) emmm不理解
	var nums []int
	lenNums1, lenNums2 := len(*nums1), len(*nums2)
	for i, j := 0, 0; ; {
		if i < lenNums1 && j < lenNums2 {
			little := 0
			if (*nums1)[i] < (*nums2)[j] {
				little = (*nums1)[i]
				i++
			} else {
				little = (*nums2)[j]
				j++
			}
			nums = append(nums, little)
		} else if i < lenNums1 {
			nums = append(nums, (*nums1)[i])
			i++
		} else if j < lenNums2 {
			nums = append(nums, (*nums2)[j])
			j++
		} else {
			break
		}
	}
	return nums
}
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	totalLen := len(nums1) + len(nums2)
	nums := mergeTwoSortedArray(&nums1, &nums2)
	mid := totalLen / 2

	if totalLen%2 == 1 {
		return float64(nums[mid])
	} else {
		return (float64(nums[mid-1]) + float64(nums[mid])) / 2
	}
}
func main() {
	fmt.Println(findMedianSortedArrays([]int{1}, []int{}))
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2, 4}))
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{4}))
	fmt.Println(findMedianSortedArrays([]int{-1, 1, 3, 5, 7, 9}, []int{2, 4, 6, 8, 10, 12, 14, 16}))
}
