# https://leetcode.com/problems/3sum/


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
        for n in nums[k + 1:]:
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
