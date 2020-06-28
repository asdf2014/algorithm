# -*- coding: utf-8 -*-
# @Time: 2020/5/25 12:37
# @Author: GraceKoo
# @File: interview_6.py
# @Desc: https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/
# coding-interviews&qru=/ta/coding-interviews/question-ranking


class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        len_rotatearray = len(rotateArray)
        if len_rotatearray <= 1:
            return rotateArray
        left = 0
        right = len_rotatearray - 1
        while left < right:
            middle = (left + right) // 2
            if rotateArray[middle] > rotateArray[right]:
                left = middle + 1
            else:
                right = middle
        return rotateArray[left]


so = Solution()
print(so.minNumberInRotateArray([1, 2, 3, 4, 5, 6, 7]))
print(so.minNumberInRotateArray([4, 5, 6, 7, 1, 2, 3]))
print(so.minNumberInRotateArray([6, 7, 1, 2, 3, 4, 5]))
