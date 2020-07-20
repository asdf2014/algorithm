# -*- coding: utf-8 -*-
# @Time: 2020/6/30 15:22
# @Author: GraceKoo
# @File: interview_50.py
# @Desc: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicateInArray(nums):
        """
        抽屉原理
        :type nums: List[int]
        :rtype int
        """
        left_value = 1
        right_value = len(nums) - 1
        while left_value < right_value:
            middle_value = int(left_value + (right_value - left_value) / 2)
            count_left = 0
            count_right = 0
            for value in nums:
                if left_value <= value <= middle_value:
                    count_left += 1
                else:
                    count_right += 1
            # 左半段存在重复（左半段的个数大于左半段的长度），根据抽屉原理，在左半段进行查找
            if count_left > middle_value - left_value + 1:
                right_value = middle_value
            # 右半段存在重复，在右半段进行查找
            else:
                left_value = middle_value + 1
        return left_value
