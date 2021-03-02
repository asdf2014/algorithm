# -*- coding: utf-8 -*-
# @Time: 2020/6/15 22:18
# @Author: GraceKoo
# @File: interview_23.py
# @Desc: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
from typing import List


class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        if not postorder:
            return False

        # 待分析的区间
        def recur(i, j):
            #  已经对比完毕，返回True
            if i >= j:
                return True
            # 根结点在最右边，左子树应该都比它小
            p = i
            while postorder[p] < postorder[j]:
                p += 1
            left_end = p
            # 右子树应该都比它小
            while postorder[p] > postorder[j]:
                p += 1
            # 若是后序遍历序列，那p应该已经和j相等了; 并且遍历左右子树序列也应该是后序遍历序列
            return p == j and recur(i, left_end - 1) and recur(left_end, j - 1)

        return recur(0, len(postorder) - 1)


so = Solution()
print(so.verifyPostorder([1, 3, 2, 6, 5]))
