# -*- coding: utf-8 -*-
# @Time: 2019/12/23 11:33 下午
# @Author: GraceKoo
# @File: 11_container-with-most-water.py
# @Desc: https://leetcode-cn.com/problems/container-with-most-water/


# comment
class Solution:
    def maxArea(self, height) -> int:
        if not height:
            return 0
        i, j = 0, len(height) - 1
        max_size = 0
        while i < j:
            if height[i] < height[j]:
                tmp_size = (j - i) * height[i]
                i += 1
            else:
                tmp_size = (j - i) * height[j]
                j -= 1
            max_size = tmp_size if tmp_size > max_size else max_size
        return max_size


so = Solution()
assert so.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])
