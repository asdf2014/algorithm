# https://leetcode.com/problems/3sum/

# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
# Find all unique triplets in the array which gives the sum of zero.
#
# Note:
# The solution set must not contain duplicate triplets.
#
# Example:
# Given array nums = [-1, 0, 1, 2, -1, -4],
#
# A solution set is:
# [
#  [-1, 0, 1],
#  [-1, -1, 2]
# ]
#
# Related Topics Array Two Pointers


# 从 nums 中找到三个数，满足和为 0
def sum3(nums):
    if len(nums) < 3:
        return []
    nums.sort()
    res = []
    for k, v in enumerate(nums[:-2]):
        if k >= 1 and v == nums[k - 1]:
            continue
        cache = {}
        for n in nums[k + 1 :]:
            if n not in cache:
                cache[-v - n] = 1
            else:
                tmp = [v, -v - n, n]
                if tmp not in res:
                    res += [tmp]
    return res


assert sum3([-1, 0]) == []
assert sum3([0, 0, 0, 0]) == [[0, 0, 0]]
assert sum3([-1, 0, 1, 2, -1, -4]) == [[-1, 0, 1], [-1, -1, 2]]
