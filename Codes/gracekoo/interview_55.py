# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16
# @Author: GraceKoo
# @File: interview_55.py
# @Desc: https://leetcode-cn.com/problems/linked-list-cycle/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def EntryNodeOfLoop(self, pHead):
        # write code here
        if not pHead or not pHead.next or pHead.next.next:
            return None
        slow = pHead.next
        fast = pHead.next.next

        # 让快指针走两步，慢指针走一步，这样如果存在环，快慢指针就会相遇
        while fast != slow and fast.next:
            slow = slow.next
            fast = fast.next.next
        # 如果相遇了
        if slow == fast:
            # 慢指针指向表头，快指针停留在相遇点
            slow = pHead
            # 两个指针分别从链表头和相遇点出发，最后一定相遇于环入口
            while slow != fast:
                slow = slow.next
                fast = fast.next
            return slow

        # 否则不存在环
        return None
