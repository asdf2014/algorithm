# -*- coding: utf-8 -*-
# @Time: 2019/12/4 12:14 上午
# @Author: GraceKoo
# @File: 4_find_median_sorted_array.py
# @Desc: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
import timeit


class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        m = len(nums1)
        n = len(nums2)
        k = (m + n) % 2
        if k == 1:
            return self.find_k(nums1, nums2, (m + n) // 2)
        else:
            return (
                self.find_k(nums1, nums2, (m + n) // 2 - 1)
                + self.find_k(nums1, nums2, (m + n) // 2)
            ) / 2

    def find_k(self, nums1, nums2, k):
        if not nums1:
            return nums2[k]
        if not nums2:
            return nums1[k]
        # print("len nums1:", len(nums1), "len nums2:", len(nums2))
        i = len(nums1) // 2
        j = len(nums2) // 2
        # print(i, j, k)
        if k > i + j:
            if nums1[i] > nums2[j]:
                return self.find_k(nums1, nums2[j + 1 :], k - j - 1)
            else:
                return self.find_k(nums1[i + 1 :], nums2, k - i - 1)
        else:
            if nums1[i] > nums2[j]:
                return self.find_k(nums1[:i], nums2, k)
            else:
                return self.find_k(nums1, nums2[:j], k)


if __name__ == "__main__":
    so = Solution()
    nums1 = [1, 2, 3]
    nums2 = [1, 2, 3]
    start = timeit.default_timer()
    print(so.findMedianSortedArrays(nums1, nums2))
    end = timeit.default_timer()
    print(str((end - start) * 1000), "s")
    nums1 = [1, 2, 3]
    nums2 = [4, 5, 6]
    print(so.findMedianSortedArrays(nums1, nums2))
    nums1 = [1, 2, 3]
    nums2 = [4, 5]
    print(so.findMedianSortedArrays(nums1, nums2))
    nums1 = [1, 4, 6]
    nums2 = [2, 5]
    print(so.findMedianSortedArrays(nums1, nums2))
