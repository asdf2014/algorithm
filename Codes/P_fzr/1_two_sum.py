# https://leetcode.com/problems/two-sum/


# 从 nums 中找到两个数，满足两数之和为 target
def two_sum(nums, target):

    nums_len = len(nums)
    if nums_len < 1:
        return False

    position = {}

    for i in range(len(nums)):

        n = nums[i]
        if n in position:
            return [position[n], i]
        else:
            position[target-n] = i

print(two_sum([2, 7, 11, 15], 9))



