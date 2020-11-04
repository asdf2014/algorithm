# -*- coding: utf-8 -*-
# @Time: 2020/7/16 16:41
# @Author: GraceKoo
# @File: interview_16.py
# @Desc: https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head_pre = ListNode(-1)
        pre = head_pre
        # 如果l1或者l2还未遍历完
        while l1 and l2:
            if l1.val < l2.val:
                pre.next = l1
                l1 = l1.next
            else:
                pre.next = l2
                l2 = l2.next
            # pre指向当前计算节点的上一个节点，运算结束后需指向下一个
            pre = pre.next
        pre.next = l1 if l1 is not None else l2

        return head_pre.next
