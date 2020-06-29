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
        """
        i = left
        j = right
        temp = arr[left]
        while i < j:
            while i < j and arr[j] >= temp:
                j -= 1
            arr[i] = arr[j]
            while i < j and arr[i] < temp:
                i += 1
            arr[j] = arr[i]
        arr[i] = temp
        return i


so = Solution()
print(so.getLeastNumbers([3, 2, 1], 2))
