# 执行用时 : 1136 ms
# 内存消耗 : 14.8 MB

# 方案：不需要再排序的必然是最大值or最小值，去掉他们 就是需要再继续排序的

class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        #不需要再排序的必然是最大值or最小值，去掉他们 就是需要再继续排序的
        if nums == sorted(nums):
            return 0
        while nums[-1] == max(nums):
            nums.pop()
        while nums[0] == min(nums):
            nums.pop(0)
        return len(nums)
