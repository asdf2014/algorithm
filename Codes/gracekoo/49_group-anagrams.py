# -*- coding: utf-8 -*-
# @Time: 2020/2/20 00:01
# @Author: GraceKoo
# @File: 49_group-anagrams.py
# @Desc:https://leetcode-cn.com/problems/group-anagrams/

import collections


class Solution:
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()


so = Solution()
print(so.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
