# -*- coding: utf-8 -*-
# @Time: 2020/9/16 20:41
# @Author: GraceKoo
# @File: interview_40.py
# @Desc: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/


class Solution:
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):
        # write code here
        if not array:
            return []
        len_array = len(array)
        if len_array <= 3:
            return []
        result = []
        array.sort()
        i, j = 0, 1 # i指向重复的首字符，j负责寻找
        for j in range(1, len_array):
            if array[i] != array[j]:
                # 如果间隔小于1，证明重复次数小于1
                if j - i == 1:
                    result.append(array[i])
                # 如果间隔大于1，证明j又找到一个新的不相等的数
                i = j
        # 最后需要判断下最后一个字符
        if array[-1] != array[-2]:
            result.append(array[-1])
        return ",".join(str(_) for _ in result)


so = Solution()
print(so.FindNumsAppearOnce([2, 4, 3, 6, 3, 2, 5, 5]))
