# -*- coding: utf-8 -*-
# @Time: 2020/4/6 00:06
# @Author: GraceKoo
# @File: 92_reverse-linked-list-ii.py
# @Desc: https://leetcode-cn.com/problems/reverse-linked-list-ii/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if m == n:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        a, d = dummy, dummy
        for _ in range(m - 1):
            a = a.next
        for _ in range(n):
            d = d.next
        b, c = a.next, d.next
        # pre, cur, next用于遍历子链表
        pre = b
        cur = pre.next
        while cur != c:
            cur.next, pre, cur = pre, cur, cur.next
            # 以上写法等价于
            # next = cur.next
            # cur.next = pre
            # pre = cur
            # cur = next
        #  首尾相接
        a.next = d
        b.next = c
        return dummy.next


head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head_tmp = head
while head_tmp:
    print(head_tmp.val)
    head_tmp = head_tmp.next
so = Solution()
return_head = so.reverseBetween(head, 2, 3)
return_head_tmp = return_head
while return_head_tmp:
    print(return_head_tmp.val)
    return_head_tmp = return_head_tmp.next
