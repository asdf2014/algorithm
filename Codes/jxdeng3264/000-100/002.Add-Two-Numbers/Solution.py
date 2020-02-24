#!/usr/bin/env python
# encoding: utf-8
# author: pyclearl


# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# leetcode这里要注释掉才能AC


class Solution(object):
    def __init__(self):
        self.carry = 0

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p, q = l1, l2
        result = curr = ListNode(0)
        while p or q:
            val_p = p.val if p else 0
            val_q = q.val if q else 0
            _sum = self.carry + val_p + val_q
            self.carry = _sum / 10
            curr.next = ListNode(_sum % 10)
            curr = curr.next
            if p:
                p = p.next
            if q:
                q = q.next
        if self.carry > 0:
            curr.next = ListNode(self.carry)
        return result.next


if __name__ == "__main__":
    pass
