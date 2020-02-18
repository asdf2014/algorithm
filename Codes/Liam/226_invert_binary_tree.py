# 执行用时 : 28 ms
# 内存消耗 : 13 MB

# 方案：递归

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        # 先序遍历，从顶向下交换
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)

        # #后序遍历，从下往上交换
        # leftNode, rightNode = self.invertTree(root.left), self.invertTree(root.right)

        # root.right = leftNode
        # root.left = rightNode

        return root
