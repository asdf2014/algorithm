# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16
# @Author: GraceKoo
# @File: interview_55.py
# @Desc: https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def EntryNodeOfLoop(self, pHead):
        # write code here
        if pHead is None and pHead.next is None:
            return None
        onestep = pHead
        twostep = pHead
        # 之所以不用写twostep.next.next， 是因为如果twostep.next.next为None，则下次循环twostep就为None了，就会退出
        while twostep and twostep.next:
            onestep = onestep.next
            twostep = twostep.next.next
            if onestep == twostep:
                onestep = pHead
                while onestep != twostep:
                    onestep = onestep.next
                    twostep = twostep.next
                return onestep
        return None
