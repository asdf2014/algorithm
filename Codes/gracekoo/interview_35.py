# -*- coding: utf-8 -*-
# @Time: 2020/8/24 20:27
# @Author: GraceKoo
# @File: interview_35.py
# @Desc: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
from typing import List


class Solution:
    def __init__(self):
        self.count = 0

    def reversePairs(self, nums: List[int]) -> int:
        """
        用于分解
        """

        def mergeSort(nums):

            len_nums = len(nums)
            # 递归的出口
            if len_nums <= 1:
                return nums
            mid = len_nums // 2

            # 分解成两个更小的数组
            nums1 = mergeSort(nums[:mid])
            nums2 = mergeSort(nums[mid:])

            return merge(nums1, nums2)

        """
        用于合并:将产生一个排好序的数组
        """

        def merge(nums1, nums2):
            i, j = len(nums1) - 1, len(nums2) - 1
            sum_nums = [0] * (i + j + 2)  # 用于存储两个列表合并后的结果
            sum_nums_index = len(sum_nums) - 1  # 当前临时列表的索引

            # 两个列表，逐个元素进行对比，大的元素将添加到结果中
            while i >= 0 and j >= 0:
                # 存在一对逆序
                if nums1[i] > nums2[j]:
                    self.count += j + 1
                    sum_nums[sum_nums_index] = nums1[i]
                    i -= 1
                    sum_nums_index -= 1
                else:
                    sum_nums[sum_nums_index] = nums2[j]
                    j -= 1
                    sum_nums_index -= 1

            # 将未添加完的元素增加到sum_nums后面
            while i >= 0:
                sum_nums[sum_nums_index] = nums1[i]
                i -= 1
                sum_nums_index -= 1
            while j >= 0:
                sum_nums[sum_nums_index] = nums2[j]
                j -= 1
                sum_nums_index -= 1
            return sum_nums

        mergeSort(nums)
        return self.count


so = Solution()
print(so.reversePairs([1, 3, 2, 3, 1]))
