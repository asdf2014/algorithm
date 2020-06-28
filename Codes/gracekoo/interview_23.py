# -*- coding: utf-8 -*-
# @Time: 2020/6/15 22:18
# @Author: GraceKoo
# @File: interview_23.py
# @Desc: https://leetcode-cn.com/problems/
# er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
from typing import List


class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        if not postorder:
            return False

        def is_post_tree(i, j):
            if i >= j:
                return True
            # 找寻根结点的左子树，应该都小于根节点
            p = i
            while postorder[p] < postorder[j]:
                p += 1
            # 找寻根结点的右子树，应该都大于根节点
            m = p
            while postorder[p] > postorder[j]:
                p += 1
            return (
                p == j
                and is_post_tree(postorder[i : m - 1])
                and is_post_tree(postorder[m : j - 1])
            )

        return is_post_tree(0, len(postorder) - 1)


so = Solution()
print(so.verifyPostorder([1, 3, 2, 6, 5]))
