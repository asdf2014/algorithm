# -*- coding: utf-8 -*-
# @Time: 2020/5/9 23:22
# @Author: GraceKoo
# @File: interview_3.py
# @Desc: https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class ListNode:
    # 链表的构造 初始化
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, list_node: ListNode):
        stack = []
        while list_node:
            stack.append(list_node.val)
            list_node = list_node.next
        # 将栈进行弹出
        # return stack[::-1]
        while stack:
            print(stack.pop())
