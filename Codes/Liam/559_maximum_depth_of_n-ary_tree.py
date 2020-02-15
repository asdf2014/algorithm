# 执行用时 : 52 ms
# 内存消耗 : 15 MB

# 方案：递归

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def maxDepth(self, root: "Node") -> int:
        if root is None:
            return 0

        # Only root and no children
        if root.children is None or len(root.children) == 0:
            return 1

        return 1 + max(map(self.maxDepth, root.children))
