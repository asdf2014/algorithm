class Solution(object):
    global_records = dict()

    def p(self, nums, target):
        result = []
        tempdict = dict()
        for m in nums:
            if target - m in tempdict:
                if m in self.global_records and target - m in self.global_records[m]:
                    continue
                result.append([m, target - m])
                if m in self.global_records:
                    self.global_records[m].append(target - m)
                else:
                    self.global_records[m] = [target - m]
                if target - m in self.global_records:
                    self.global_records[target - m].append(m)
                else:
                    self.global_records[target - m] = [m]
            tempdict[m] = 1
        return result

    def threeSum(self, nums):
        self.global_records = dict()
        nums = sorted(nums)
        result = []
        n = 0
        while n < len(nums) - 1:
            ts = [x + [nums[n]] for x in self.p(nums[n + 1 :], -nums[n])]
            result += ts
            n += 1
        return result
