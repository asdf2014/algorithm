# -*- coding: utf-8 -*-
# @Time: 2020/3/26 19:29 
# @Author: GraceKoo
# @File: 82_remove-duplicates-from-sorted-list-ii.py
# @Desc:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        tmp_head = ListNode("head")
        tmp_head.next = head
        pre, cur = None, tmp_head

        while cur:
            pre = cur  # pre指向不重复的节点， cur指向当前节点
            cur = cur.next  # cur指向pre的下一个节点
            while cur and cur.next and cur.next.val == cur.val:
                value = cur.val
                # 找到不重复的节点
                while cur and cur.val == value:
                    cur = cur.next
            pre.next = cur
        return tmp_head.next


first_node = ListNode(0)
first_node.next = ListNode(2)
first_node.next.next = ListNode(2)
print(first_node.val, first_node.next.val, first_node.next.next.val)

so = Solution()
last_node = so.deleteDuplicates(first_node)
while last_node:
    print(last_node.val)
    last_node = last_node.next

