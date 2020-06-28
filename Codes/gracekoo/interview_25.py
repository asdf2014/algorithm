# -*- coding: utf-8 -*-
# @Time: 2020/6/19 10:28
# @Author: GraceKoo
# @File: interview_25.py
# @Desc: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/


# Definition for a Node.
class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: "Node") -> "Node":
        def dfs(head):
            if not head:
                return None
            if head in visited:
                return visited[head]
            copy = Node(head.val, None, None)
            visited[head] = copy
            copy.next = dfs(head.next)
            copy.random = dfs(head.random)
            return copy

        visited = {}
        return dfs(head)
