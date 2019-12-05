# 执行用时 : 92 ms
# 内存消耗 : 12.1 MB

# 方案：借助自带的sorted()函数


class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        merged = sorted(nums1 + nums2)
        middle = len(merged) // 2

        if len(merged) % 2 == 0:
            return float(merged[middle - 1] + merged[middle]) / 2
        else:
            return sorted(merged)[len(merged) // 2]
