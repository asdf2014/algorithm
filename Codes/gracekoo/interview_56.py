# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16
# @Author: GraceKoo
# @File: interview_56.py
# @Desc: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplication(self, pHead):
        # write code here
        head = ListNode(-1)  # 指向头节点
        p = head  # 指向不重复的结点
        p.next = pHead
        cur = pHead  # 负责找到重复结点
        while cur and cur.next:
            if cur.val != cur.next.val:
                cur = cur.next
                p = p.next
            else:
                cur_val = cur.val
                while cur and cur.val == cur_val:
                    cur = cur.next
                # 不相同则令p指向不重复的元素
                p.next = cur
        return head.next
