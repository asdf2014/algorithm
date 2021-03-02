# 执行用时 : 40 ms
# 内存消耗 : 13.6 MB

# 方案：从根节点开始dfs遍历树

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        def dfs(node, num):
            if not node:
                return 0

            num = num * 2 + node.val
            if not node.left and not node.right:
                return num

            return dfs(node.left, num) + dfs(node.right, num)

        return dfs(root, 0)
