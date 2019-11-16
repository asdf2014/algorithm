# https://leetcode.com/problems/search-insert-position/


def search_insert(nums, target):
    return len([i for i in nums if i < target])


assert search_insert([1, 3, 5, 6], 5) == 2
assert search_insert([1, 3, 5, 6], 2) == 1
assert search_insert([1, 3, 5, 6], 7) == 4
assert search_insert([1, 3, 5, 6], 0) == 0
