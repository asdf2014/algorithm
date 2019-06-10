"""
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
"""
'''
解题思考1：

一般的做法是，逐两项相加判断是否和目标值相等，其时间复杂度为O(n^2)

解题思考2：

其中一个循环其实可以看作一次查找，将当下计算遍历值进行一次缓存，下次遍历时计算差值
从缓存中查找。找到的话相当于之前某个位置和当前项的和就是目标值，取出之前存储的值的
索引值和当前值索引值返回即可。时间复杂度可降低为O(n)

技巧：
如果不在乎空间复杂度问题：适当的将遍历查找的子过程转换为字典查找过程，可以降低一层O(n)为O(1)


'''
class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        cache = {}
        index = 0
        for num in nums:
            diff = target - num
            if diff in cache:
                return [cache[diff],index]
            cache[num] = index
            index += 1

print(Solution().twoSum([7, 2, 11, 15, 4], 6))
