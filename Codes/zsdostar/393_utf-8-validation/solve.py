#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Author  : Star
@Email   : zsdzzydos@gmail.com
@Time    : 2019年09月09日 14:26
@Desc    : UTF-8 编码验证
            读明白题花了半天。。死扣细节的一个题
            232 ms, 14.4 MB
"""
from typing import List


class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        bin_data = self.get_bin_list(data)
        i = 0
        while i < len(bin_data):
            step = self.which_module(bin_data[i])
            if not step:
                return False
            if step == 1:
                i += step
                continue
            if step == 2 and self.ok_child([bin_data[i + 1]]) and i + 1 < len(bin_data):
                i += step
            elif self.ok_child(bin_data[i + 1:i + step]) and i + step < len(bin_data) + 1:
                i += step
            else:
                return False
        return True

    @staticmethod
    def which_module(s):
        """
            判断是几个字节的二进制字符
        """
        if s[0] == '0':
            return 1
        elif s[:3] == '110':
            return 2
        elif s[:4] == '1110':
            return 3
        elif s[:5] == '11110':
            return 4
        else:
            return 0

    @staticmethod
    def ok_child(s):
        for i in s:
            if i[:2] != '10':
                return False
        return True

    @staticmethod
    def get_bin_list(l):
        """
            转换为二进制字符串数组
        """
        return ['%08d' % int(bin(_).replace('0b', '')) for _ in l]


if __name__ == '__main__':
    s = Solution()
    assert s.validUtf8([197, 130, 1]) is True
    assert s.validUtf8([235, 140, 4]) is False
