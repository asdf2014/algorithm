#执行用时 : 348 ms
#内存消耗 : 13 MB

#方案：哈希表

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #创建哈希表{value:idx}
        record={}
        #遍数组
        for idx, value in enumerate(nums):
            #如果差值在哈希表中,返回对应索引 以及 循环中本次idx
            #如果差值不在，则在哈希表中插入该value:idx
            if (target - value) in record.keys():
                return [record[target - value], idx]
            else:
                record[value] = idx
