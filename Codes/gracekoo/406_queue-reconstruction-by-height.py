# -*- coding: utf-8 -*-
# @Time: 2020/5/14 19:37
# @Author: GraceKoo
# @File: 406_queue-reconstruction-by-height.py
# @Desc: https://leetcode-cn.com/problems/queue-reconstruction-by-height/
from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # 按照x[0]的逆序（所以为-x[0]），x[1]的正序进行排序
        people.sort(key=lambda x: (-x[0], x[1]), reverse=False)
        out_put_people = []
        # 根据索引，依次做插入操作
        for person in people:
            out_put_people.insert(person[1], person)
        return out_put_people


so = Solution()
print(so.reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 2], [6, 1], [5, 0]]))
