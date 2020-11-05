# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:58
# @Author: GraceKoo
# @File: interview_63.py
# @Desc: https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
from heapq import *


class MedianFinder:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.A = []  # 大顶堆，存放较小的元素
        self.B = []  # 小顶堆，存放较大的元素，使得B的最小的元素也比A中最大的元素大，保证数据流保持有序

    def addNum(self, num: int) -> None:
        # 数据流长度为奇数时，需向A中插入元素：先向B中插入num，再将B的堆顶元素插入至A，保证B比A大
        if len(self.A) != len(self.B):
            heappush(self.B, num)
            heappush(self.A, -heappop(self.B))
        # 数据流长度为偶数时，需向B中插入元素：先向A中插入num，再将A的堆顶元素插入至B，保证B比A大
        else:
            heappush(self.A, -num)
            heappush(self.B, -heappop(self.A))

    def findMedian(self) -> float:
        if len(self.A) != len(self.B):
            return self.B[0]
        else:
            # A由于是存放的都是相反数，所以计算时，A中最大的数其实在A[0],也就是-A[0]是A中最大的数
            return (-self.A[0] + self.B[0]) / 2.0


# Your MedianFinder object will be instantiated and called as such:
obj = MedianFinder()
obj.addNum(3)
obj.addNum(4)
obj.addNum(5)
param_2 = obj.findMedian()
