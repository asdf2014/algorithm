#! coding:utf-8


def twoSum(nums, target):
    """
    解题思路
    用哈希的办法，
    valuer作为下标，key为target-num1
    """
    if nums is None:
        return False
    else:
        m = {}
        for i, j in enumerate(nums):
            if j in m:
                return [m[j], i]
            else:
                m[target - j] = i
