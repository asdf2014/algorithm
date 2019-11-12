'''
1. 两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中
找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
'''
'''
方式一：
	两层循环分别遍历 nums，在内层循环内，判断两数和是否为 target。
	( 时间复杂度：O(n^2) )

方式二：
	假设存在下标分别为 i 和 j 两数和为 target, 
		则 nums[j] = target - nums[i].
	因此一层循环遍历 nums，并判断数 target-nums[i] 是否在数组 nums 中。
		若存在，则返回对应下标。
	( 时间复杂度：O(n) )

'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        for i, x in enumerate(nums):
            if target-x in hash_map:
                return [hash_map[target - x], i]
            hash_map[x] = i

