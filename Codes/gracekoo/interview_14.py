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
        p = head
        q = head
        count = 0
        while p:
            p = p.next
            count += 1
            if count >= k+1:
                q = q.next
        if k > count:
            return None
        return q

