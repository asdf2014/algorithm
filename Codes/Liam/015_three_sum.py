#超时，需要优化
class Solution(object):
    flag = {}
    def two_sum(self, cur_value, nums, target):
        #输入数组，输出 和为target 的 两个idx 的数组
        rst=[]
        record={}
        for idx, value in enumerate(nums):
            if (target - value) in record.keys():
                rst.append(tuple(sorted([cur_value, value, target - value])))
            else:
                record[value] = idx
        return rst

    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rst = []
        #小于3 返回false
        if len(nums) < 3:
            return 
        #等于3 若数组和为0 返回true 否则 false
        elif len(nums) == 3:
            if sum(nums) == 0:
                return [nums]
        #大于三，拆成1+2 并对2进行two_sum判断
        else:
            for idx, value in enumerate(nums):
                tmp = nums[0:idx] + nums[idx+1:] if idx != len(nums) else nums[0:idx]
                rst.extend(self.two_sum(value, tmp, -value))
            return set(rst)
