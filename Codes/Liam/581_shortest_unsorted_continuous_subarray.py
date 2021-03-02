# 执行用时 : 1136 ms
# 内存消耗 : 14.8 MB

# 方案：不需要再排序的必然是最大值or最小值，去掉他们 就是需要再继续排序的


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        # 不需要再排序的必然是最大值or最小值，去掉他们 就是需要再继续排序的
        if nums == sorted(nums):
            return 0
        while nums[-1] == max(nums):
            nums.pop()
        while nums[0] == min(nums):
            nums.pop(0)
        return len(nums)

        # 执行用时 : 276 ms
        # 内存消耗 : 14.8 MB

        # 方案：排序之后，双指针进行对比

        sorted_nums = sorted(nums)  # lgtm [py/unreachable-statement]
        p1 = 0
        p2 = len(nums) - 1
        while p1 <= p2 and sorted_nums[p1] == nums[p1]:
            p1 += 1
        while p1 <= p2 and sorted_nums[p2] == nums[p2]:
            p2 -= 1
        return p2 - p1 + 1
