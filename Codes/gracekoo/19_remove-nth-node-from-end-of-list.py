# -*- coding: utf-8 -*-
# @Time: 2019/12/31 12:11 下午
# @Author: GraceKoo
# @File: 19_remove-nth-node-from-end-of-list.py
# @Desc: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if not head:
            return head
        # 哑节点用来简化某些极端情况，例如列表中只有含有一个节点，或需要删除列表的头部
        dum = ListNode(0)
        fro_head = head
        dum.next = head
        for i in range(n):
            head = head.next
        # 如果end已经走到末尾，则证明比n长，直接退出
        if not head:
            return fro_head.next
        while head.next:
            fro_head = fro_head.next
            head = head.next
        fro_head.next = fro_head.next.next
        return dum.next
