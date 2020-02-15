# 执行用时 : 72 ms
# 内存消耗 : 15.5 MB

# 方案：递归

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findTilt(self, root: TreeNode) -> int:
        def sum_and_tilt(root):
            if not root:
                return 0, 0
            sum_left, tilt_left = sum_and_tilt(root.left)
            sum_right, tilt_right = sum_and_tilt(root.right)
            return sum_left + sum_right + root.val, abs(sum_left - sum_right) + tilt_left + tilt_right
        
        sum_tree, tilt_tree = sum_and_tilt(root)
        return tilt_tree
