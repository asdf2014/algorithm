# -*- coding: utf-8 -*-
# @Time: 2020/7/16 16:28
# @Author: GraceKoo
# @File: interview_14.py
# @Desc: https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        if not head:
            return None
        # 让p，q相隔k个
        p = head
        q = head
        count = 0
        while p:
            p = p.next
            count += 1
            # count至少大于等于2的时候才p才走
            if count >= k + 1:
                q = q.next
        # 当k的长度比链表都长时，直接返回None
        if k > count:
            return None
        return q
