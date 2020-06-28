# -*- coding: utf-8 -*-
# @Time: 2020/5/30 11:35
# @Author: GraceKoo
# @File: interview_13.py
# @Desc: https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/
# coding-interviews&qru=/ta/coding-interviews/question-ranking


class Solution:
    def reOrderArray(self, array):
        # write code here
        len_array = len(array)
        if len_array <= 1:
            return array
        left = 0
        right = len_array - 1
        while left <= right:
            # 如果是偶数，就添加到末尾
            if array[left] & 1 == 0:
                array.append(array.pop(left))
                right -= 1
            else:
                left += 1
        return array


so = Solution()
print(so.reOrderArray([1, 2, 3, 4, 5]))
