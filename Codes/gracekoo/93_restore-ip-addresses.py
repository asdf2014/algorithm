# -*- coding: utf-8 -*-
# @Time: 2020/4/7 23:22
# @Author: GraceKoo
# @File: 93_restore-ip-addresses.py
# @Desc:https://leetcode-cn.com/problems/restore-ip-addresses/
from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        r = []

        def restore(count=0, ip="", s=""):
            if count == 4:
                if s == "":
                    r.append(ip[:-1])
                return
            if len(s) > 0:
                restore(count + 1, ip + s[0] + ".", s[1:])
            if len(s) > 1 and s[0] != "0":
                restore(count + 1, ip + s[:2] + ".", s[2:])
            if len(s) > 2 and s[0] != "0" and int(s[0:3]) < 256:
                restore(count + 1, ip + s[:3] + ".", s[3:])

        restore(0, "", s)
        return r


so = Solution()
print(so.restoreIpAddresses("25525511135"))
