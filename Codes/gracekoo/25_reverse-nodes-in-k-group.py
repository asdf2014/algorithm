# -*- coding: utf-8 -*-
# @Time: 2020/1/8 10:03 下午
# @Author: GraceKoo
# @File: 25_reverse-nodes-in-k-group.py
# @Desc:https://leetcode-cn.com/problems/reverse-nodes-in-k-group/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        tmp_head = ListNode(0)
        tmp_head.next = head
        pre = tail = tmp_head
        while True:
            count = k
            # 将tail移动k个节点
            while count and tail:
                count -= 1
                tail = tail.next
            # 如果tail为空，则当前的这组节点数量小于k个，跳出，不进行反转
            if not tail:
                break
            # 否则反转这k个节点
            head = pre.next  # head 用于记录当前这组翻转节点的第一个节点
            while pre.next != tail:
                current_node = pre.next  # current_node 指向当前正在准备移动的节点
                pre.next = current_node.next
                current_node.next = tail.next
                tail.next = current_node
                pre = pre.next
            pre, tail = head  # 指向上组移动的第一个节点

        return tmp_head.next

