import sys


class Solution(object):

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        length = len(nums)
        if length == 3:
            return sum(nums)
        res = sum(nums[:3])
        for i in range(0, length-2):
            m, n = i+1, length-1
            while m < n:
                ng = nums[i]+nums[n] + nums[m]
                if abs(ng-target) < abs(res-target):
                    res = ng
                if ng-target > 0:
                    n -= 1
                elif ng-target == 0:
                    return target
                else:
                    m += 1
        return res
