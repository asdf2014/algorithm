# https://leetcode.com/problems/permutations/

# Given a collection of distinct integers, return all possible permutations.
#
# Example:
# Input: [1,2,3]
# Output:
# [
#  [1,2,3],
#  [1,3,2],
#  [2,1,3],
#  [2,3,1],
#  [3,1,2],
#  [3,2,1]
# ]
#
# Related Topics Backtracking


def permutations(nums):
    res = []
    backtrack(nums, [], res)
    return res


def backtrack(nums, tmp, res):
    if len(tmp) == len(nums):
        res.append(tmp[:])
        return
    for n in nums:
        if n in tmp:
            continue
        tmp.append(n)
        backtrack(nums, tmp, res)
        tmp.pop()


assert permutations([]) == [[]]
assert permutations([1]) == [[1]]
assert permutations([1, 2]) == [[1, 2], [2, 1]]
assert permutations([1, 2, 3]) == [
    [1, 2, 3],
    [1, 3, 2],
    [2, 1, 3],
    [2, 3, 1],
    [3, 1, 2],
    [3, 2, 1],
]
