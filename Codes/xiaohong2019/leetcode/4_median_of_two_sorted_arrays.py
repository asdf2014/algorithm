# -*- coding: utf-8 -*-
# URL : https://leetcode-cn.com/problems/median-of-two-sorted-arrays/

""""""

"""
problem:
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
"""

"""
explain:
看清楚，复杂度是 O(log(m + n))，而不是 O(m + n)，所以不能合并这两个数组，要原封不动，用下标去访问找出中位数。
中位数就是排序数组序列的中间位置的元素，奇数个元素取一个中间元素，偶数个元素取中间两个元素求平均。
要寻找的两个元素（非下标）：(m + n + 1) / 2，(m + n + 2) / 2，当元素个数为奇数个时，这两个值是相等的，因此可以寻找这两个位置的元素出来求平均。
题目转变成找出第 k 个的元素，这里的 k 就是上面那两个。
这两个数组，是各自有序，要找这两个的元素，就需要进行比较淘汰。
找第 k 个元素的过程：
取出各自下标为 k / 2 - 1 的元素，也就是中间元素，这里就可以使得复杂度为 log 级别。
如果 nums1 < nums2，就表明 nums1 前面 k / 2 不可能有合并之后的 k，可以淘汰 nums1 的前 k / 2 个元素；
如果 nums1 > nums2，也表明 nums2 前面 k / 2 可以淘汰。
淘汰之后，k 变为 k - k / 2。
另外，k == 1 时，就不存在 k / 2（中间元素），此时比较 nums1、nums2 当前索引值的大小，取小的那一个，因为这里是取第 1（k） 个元素。
当索引值超出对应的 nums 长度时，表明 k 在另一个数组中，可以返回下标为 （索引值 + k - 1） 的元素，其中（k - 1）就是取下标。

演示：
nums1 = [1, 2, 3]
nums2 = [4, 5, 6]
根据 (m + n + 1) / 2，(m + n + 2) / 2，需要找出第 3，4 这两个元素，求平均值
初始索引值：index1 = index2 = 0

找 k == 3 的过程：
1. 根据 k / 2 - 1，各自取出下标为 0 的元素，分别是 1 和 4；由于 1 < 4，所以淘汰 nums1 中的前 k / 2 个元素，即 index1（索引值）为 1。
2. 根据 k - k / 2，k 变更为 2。
3. 变成寻找 k == 2 的过程，重复 1、2 步骤。
4. 各自取出下标为 0 的元素（叠加索引值），分别是 2 和 4；由于 2 < 4，所以 nums1 只剩下 3 这个元素，即 index1 == 2。
5. k 变更为 1。
6. 比较 nums1、nums2 当前索引值的大小，取小的那一个，即 3 和 4，取元素 3。

找 k == 4 的过程：
1. 根据 k / 2 - 1，各自取出下标为 1 的元素，分别是 2 和 5；由于 2 < 5，所以淘汰 nums1 中的前 k / 2 个元素，即 index1（索引值）为 2。
2. 根据 k - k / 2，k 变更为 2。
3. 变成寻找 k == 2 的过程，重复 1、2 步骤。
4. 各自取出下标为 0 的元素（叠加索引值），分别是 3 和 4；由于 3 < 4，所以 index1 == 3。
5. k 变更为 1。
6. 判断 index1 >= nums1.length，即 nums1 全部淘汰，取 nums2 中下标为 （index2 + k - 1）的元素，即元素 4。

平均值（中位数）：
(3 + 4) / 2 = 3.5
"""

"""
out:
执行用时 : 88 ms, 在所有 python 提交中击败了 63.81% 的用户
内存消耗 : 11.8 MB, 在所有 python 提交中击败了 32.58% 的用户
"""


class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m = len(nums1)
        n = len(nums2)

        def find_kth(nums1, nums2, index1, index2, k):
            # 索引值范围检查
            if index1 >= len(nums1):
                return nums2[index2 + k - 1]
            if index2 >= len(nums2):
                return nums1[index1 + k - 1]

            # k == 1
            if k == 1:
                return nums1[index1] if nums1[index1] < nums2[index2] else nums2[index2]

            # 取中间值比较淘汰
            do_discard_nums1 = True
            mid = k // 2 - 1
            if index1 + mid >= len(nums1) or (
                index2 + mid < len(nums2) and nums1[index1 + mid] > nums2[index2 + mid]
            ):
                do_discard_nums1 = False
            mid += 1
            if do_discard_nums1:
                # 淘汰 nums1 的 mid 前面的元素
                return find_kth(nums1, nums2, index1 + mid, index2, k - mid)
            else:
                return find_kth(nums1, nums2, index1, index2 + mid, k - mid)

        return (
            find_kth(nums1, nums2, 0, 0, (m + n + 1) // 2)
            + find_kth(nums1, nums2, 0, 0, (m + n + 2) // 2)
        ) / 2.0


if __name__ == "__main__":
    solution = Solution()
    assert solution.findMedianSortedArrays([1, 3], [2]) == 2.0
    assert solution.findMedianSortedArrays([2], [1, 3]) == 2.0
    assert solution.findMedianSortedArrays([1, 2], [3, 4]) == 2.5
    assert solution.findMedianSortedArrays([1, 3], [2, 4]) == 2.5
    assert solution.findMedianSortedArrays([], [1]) == 1.0
    assert solution.findMedianSortedArrays([1], []) == 1.0
    assert solution.findMedianSortedArrays([1, 3], []) == 2.0
    assert solution.findMedianSortedArrays([], [1, 3]) == 2.0
    assert solution.findMedianSortedArrays([1, 2, 3], []) == 2.0
    assert solution.findMedianSortedArrays([], [1, 2, 3]) == 2.0
    assert solution.findMedianSortedArrays([1, 2, 3, 5], [4, 6, 7, 8, 9]) == 5.0
    assert solution.findMedianSortedArrays([1], [2, 3, 4, 5, 6]) == 3.5
