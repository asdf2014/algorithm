# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:58
# @Author: GraceKoo
# @File: interview_64.py
# @Desc: https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
from typing import List
import collections


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if k == 0:
            return []
        de = collections.deque()  # 构建一个双向单调递减队列，队列头记录当前窗口的最大值
        result, len_nums = [], len(nums)
        # right范围从0～len(nums), left范围从-k~len(nums)-k;即left与right之间保持窗口k
        for left, right in zip(range(1 - k, len_nums + 1 - k), range(len_nums)):
            # 为队列元素同步滑动窗口：队列内仅包含窗口内的元素,每轮窗口滑动移除了元素 nums[left - 1] ，需将队列内的对应元素一起删除。
            # 如果不相等，则证明当前最大不等于滑动窗口刚滑过的元素
            if left > 0 and de[0] == nums[left - 1]:
                de.popleft()

            # 为保持队列的单调性：若队列中最小的元素小于待比较的元素，则将队尾元素弹出，新元素加入队尾
            while de and de[-1] < nums[right]:
                de.pop()

            # 如果本身就小于队尾元素，则直接加入队尾
            de.append(nums[right])

            # 将每次比较的结果添加到返回列表中
            if left >= 0:
                result.append(de[0])
        return result


so = Solution()
print(so.maxSlidingWindow([2, 3, 4, 2, 6, 2, 5, 1], 3))
