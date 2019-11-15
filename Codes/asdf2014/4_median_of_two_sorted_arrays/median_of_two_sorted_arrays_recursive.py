# https://leetcode.com/problems/median-of-two-sorted-arrays/


# 时间复杂度是 O(log(min(m,n)))
# 空间复杂度为 O(1)

# 更多细节：
# https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/

def median_of_two_sorted_arrays(nums1, nums2):
    m, n = len(nums1), len(nums2)
    if m > n:
        nums1, nums2, m, n = nums2, nums1, n, m
    if n == 0:
        raise ValueError

    i_min, i_max, half = 0, m, (m + n + 1) / 2
    while i_min <= i_max:
        i = (i_min + i_max) // 2
        j = int(half - i)
        if i < m and nums2[j - 1] > nums1[i]:
            # i is too small, must increase it
            i_min = i + 1
        elif i > 0 and nums1[i - 1] > nums2[j]:
            # i is too big, must decrease it
            i_max = i - 1
        else:
            # i is perfect
            if i == 0:
                max_of_left = nums2[j - 1]
            elif j == 0:
                max_of_left = nums1[i - 1]
            else:
                max_of_left = max(nums1[i - 1], nums2[j - 1])

            if (m + n) % 2 == 1:
                return max_of_left

            if i == m:
                min_of_right = nums2[j]
            elif j == n:
                min_of_right = nums1[i]
            else:
                min_of_right = min(nums1[i], nums2[j])

            return (max_of_left + min_of_right) / 2.0


assert median_of_two_sorted_arrays([1, 3], []) == 2.0
assert median_of_two_sorted_arrays([1, 3], [2]) == 2.0
assert median_of_two_sorted_arrays([1, 2], [3, 4]) == 2.5
