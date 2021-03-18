package main

//Leetcode官方解思路是真的精妙啊~
func merge(nums1 []int, m int, nums2 []int, n int) {
	p := len(nums1) - 1
	m, n = m-1, n-1
	for p >= 0 {
		if n >= 0 && (m < 0 || nums1[m] <= nums2[n]) {
			nums1[p] = nums2[n]
			p--
			n--
		}

		if m >= 0 && (n < 0 || nums1[m] > nums2[n]) {
			nums1[p] = nums1[m]
			p--
			m--
		}
	}
}
