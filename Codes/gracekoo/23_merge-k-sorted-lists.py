# -*- coding: utf-8 -*-
# @Time: 2020/1/7 9:25 下午
# @Author: GraceKoo
# @File: 23_merge-k-sorted-lists.py
# @Desc:https://leetcode-cn.com/problems/merge-k-sorted-lists/

from queue import PriorityQueue


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeKLists(self, lists) -> ListNode:
        # 使用优先队列(堆排序)存储每个list中的第一个节点，由优先队列返回优先级最高（值最低的元素）
        head_pre = p = ListNode(0)
        prior_queue = PriorityQueue()
        for list_node in lists:
            if list_node:
                prior_queue.put((list_node.val, list_node))
        while not prior_queue.empty():
            node_val, node = prior_queue.get()
            p.next = ListNode(node_val)
            p = p.next
            # 将当前list的头指向list中的下一个节点
            node = node.next
            if node:
                prior_queue.put((node.val, node))
        return head_pre.next
