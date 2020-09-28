# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16 
# @Author: GraceKoo
# @File: interview_53.py
# @Desc: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
import re


class Solution:
    def isNumber(self, s: str) -> bool:
        matchObj = re.match('^\s*[+-]{0,1}((\d)+((\.)(\d)+){0,1}|((\.)(\d)+)|((\d)+(\.)))([eE][+-]{0,1}[\d]+){0,1}\s*$',
                            s)

        if matchObj:
            print("match --> matchObj.group() : ", matchObj.group())
            return True
        else:
            print("No match!!")
            return False
