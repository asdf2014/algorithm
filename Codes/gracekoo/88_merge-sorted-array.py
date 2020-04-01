# -*- coding: utf-8 -*-
# @Time: 2020/4/1 11:24 
# @Author: GraceKoo
# @File: 88_merge-sorted-array.py
# @Desc:https://leetcode-cn.com/problems/merge-sorted-array/
from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> List:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if not nums1:
            return nums2
        if not nums2:
            return nums1
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1
        # 如果nums2中有没有进行添加的元素，则进行添加
        nums1[:p2 + 1] = nums2[:p2 + 1]
        return nums1


so = Solution()
print(so.merge(nums1=[1, 2, 3, 0, 0, 0], m=3, nums2=[2, 5, 6], n=3))
