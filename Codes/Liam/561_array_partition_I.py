# 执行用时 : 432 ms
# 内存消耗 : 15.7 MB

# 方案：排序后 相邻两个最小的就是奇数

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        sum = 0
        for i in range(0,len(nums),2):
            sum += nums[i]
            
        return sum
