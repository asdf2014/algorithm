# -*- coding: utf-8 -*-
# @Time: 2020/8/26 20:01
# @Author: GraceKoo
# @File: interview_37.py
# @Desc: https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class Solution:
    def GetNumberOfK(self, data, k):
        # write code here
        if not data:
            return 0
        len_data = len(data)
        left, right = 0, 0
        # 先找最左边等于k的位置
        for i in range(0, len_data - 1):
            if data[i] == k:
                left = i
                break
        # 再找最右边等于k的位置
        for j in range(len_data - 1, -1, -1):
            if data[j] == k:
                right = j
                break
        # 判断临界条件
        if left == 0 and right == 0:
            if data[left] == k:
                return 1
            else:
                return 0
        return right - left + 1


so = Solution()
test = [1, 3, 3, 3, 3, 4, 5]
number = 2
print(so.GetNumberOfK(test, number))
