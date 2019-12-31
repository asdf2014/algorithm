# -*- coding: utf-8 -*-
# @Time: 2019/12/31 12:11 下午 
# @Author: GraceKoo
# @File: 19_remove-nth-node-from-end-of-list.py
# @Desc: 通过同时向前移动两个间隔为n的指针，直到第一个指针到达最后一个节点。此时第二个指针将指向从最后一个节点数起的第n个节点

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 哑节点用来简化某些极端情况，例如列表中只有含有一个节点，或需要删除列表的头部
        head_pre = ListNode(-1)
        head_pre.next, start, end = head, head_pre, head_pre
        # 让end节点向前走n步
        while end and n > 0:
            end = end.next
        # 如果end已经走到末尾，则证明比n长，直接退出
        if not end:
            return head
        while end.next:
            start, end = start.next, end.next
        # 删除倒数第n个节点
        start.next = start.next.next
        return head
