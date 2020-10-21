# -*- coding: utf-8 -*-
# @Time: 2020/6/29 16:40
# @Author: GraceKoo
# @File: interview_29.py
# @Desc: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?
# tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
from typing import List


class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        if k <= 0 or k > len(arr):
            return []
        start = 0
        end = len(arr) - 1
        pivot = self.quicksort(arr, start, end)
        while pivot != k - 1:
            if pivot > k - 1:
                end = pivot - 1
                pivot = self.quicksort(arr, start, end)
            if pivot < k - 1:
                start = pivot + 1
                pivot = self.quicksort(arr, start, end)
        return arr[:k]

    def quicksort(self, arr, left, right):
        """
        简单版快速排序
        返回一个坐标，坐标左侧都小于返回值，右侧都大于返回值
        """
        i = left
        j = right
        temp = arr[left]
        while i < j:
            # 从右侧搜索小元素，并进行交换
            while i < j and arr[j] >= temp:
                j -= 1
            arr[i] = arr[j]
            # 从左侧搜索大元素，并进行交换
            while i < j and arr[i] < temp:
                i += 1
            arr[j] = arr[i]
        # 最初left上的数字已经被覆盖了，所以需要重新赋值
        arr[i] = temp
        return i


so = Solution()
print(so.getLeastNumbers([4, 5, 1, 6, 2], 4))
