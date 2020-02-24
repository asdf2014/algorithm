# -*- coding: utf-8 -*-
# @Time : 2019/9/106:55 下午
# @Author: GraceKoo
# @File:  1_twoSum.py
# @Desc: HashMap{num1:loc1,num2:loc2......}
import timeit


class Solution:
    def twoSum(self, nums, target):
        hashmap = {}
        for loc, num in enumerate(nums):
            if hashmap.get(target - num) is not None:
                return [hashmap.get(target - num), loc]
            hashmap[num] = loc
        return None


nums = [2, 7, 3, 6, 5]
so = Solution()
start = timeit.default_timer()
print(so.twoSum(nums, 8))
end = timeit.default_timer()
print(str((end - start) * 1000), "s")  # 0.052050003432668746 s
