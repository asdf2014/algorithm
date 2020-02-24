# -*- coding: utf-8 -*-
# @Time : 2019/10/8 8:17 下午
# @Author: GraceKoo
# @File:  3_length_of_longest_substring.py
# @Desc:
import timeit


class Solution:
    def lengthoflongestsubstring(self, s: str) -> int:
        tem_length = 0
        max_length = 0
        s_set = set()
        for i in range(len(s)):
            if s[i] in s_set:
                s_set.remove(s[i])
                tem_length = 0
            else:
                s_set.add(s[i])
                tem_length += 1

            if tem_length > max_length:
                max_length = tem_length

        return max_length


if __name__ == "__main__":
    so = Solution()
    test_list = "pwdflkkkpwdsadf"
    start = timeit.default_timer()
    print(so.lengthoflongestsubstring(test_list))
    end = timeit.default_timer()
    print(str((end - start) * 1000), "s")  # s0.034690000006776245 s
