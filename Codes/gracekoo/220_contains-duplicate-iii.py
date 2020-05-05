# -*- coding: utf-8 -*-
# @Time: 2020/5/5 21:24
# @Author: GraceKoo
# @File: 220_contains-duplicate-iii.py
# @Desc: https://leetcode-cn.com/problems/contains-duplicate-iii
from typing import List


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        bucket = dict()
        if t < 0:
            return False
        for i in range(0, len(nums)):
            # 每个桶序号代表存放t的倍数的数
            bucket_nth = nums[i] // (t + 1)
            if bucket_nth in bucket:
                return True
            if bucket_nth - 1 in bucket and abs(bucket[bucket_nth - 1] - nums[i]) <= t:
                return True
            if bucket_nth + 1 in bucket and abs(bucket[bucket_nth + 1] - nums[i]) <= t:
                return True
            bucket[bucket_nth] = nums[i]
            # 当桶大于k时，代表窗口已经越界，越界元素可以进行清除
            if i >= k:
                bucket.pop(nums[i - k] // (t + 1))
        return False


so = Solution()
print(so.containsNearbyAlmostDuplicate(nums=[1, 5, 9, 1, 5, 9], k=2, t=3))
