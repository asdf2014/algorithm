# -*- coding: utf-8 -*-
# @Time: 2020/3/21 22:48
# @Author: GraceKoo
# @File: 76_minimum-window-substring.py
# @Desc:https://leetcode-cn.com/problems/minimum-window-substring
from collections import Counter
from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        left, right = 0, 0
        length_s = len(s)
        result = s + s  # 随便设定一个比s长的字符串，便于后续处理
        t_dict = Counter(t)  # t各个数字的出现的次数
        count_dict = defaultdict(lambda: 0)  # 创建一个默认值为0的字典

        # 判断当前字典与目标字典长度、存储的值是否相同
        def contains(t_dict, count_dict):
            if len(count_dict) < len(t_dict):
                return False
            for key in count_dict:
                if count_dict[key] < t_dict[key] or key not in t_dict:
                    return False
            return True

        # 触发right移动
        for right in range(length_s):
            if s[right] in t_dict:
                count_dict[s[right]] += 1

            #  触发left移动: 当前存储的字典中与目标字典中长度、包含的值相同
            while left < length_s and contains(t_dict, count_dict):
                # 更新结果
                if right - left + 1 < len(result):
                    result = s[left : right + 1]
                if s[left] in t_dict:
                    count_dict[s[left]] -= 1
                left += 1
        return "" if result == s + s else result


so = Solution()
print(so.minWindow("ADOBECODEBANC", "ABC"))
