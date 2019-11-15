# https://leetcode.com/problems/median-of-two-sorted-arrays/


def median_of_two_sorted_arrays(nums1, nums2):
    nums = []
    count1 = 0
    count2 = 0
    len1 = len(nums1)
    len2 = len(nums2)
    total_len = len1 + len2

    for i in range(total_len):
        # collect the tail
        if count1 == len1:
            nums.extend(nums2[count2::])
            break
        if count2 == len2:
            nums.extend(nums1[count1::])
            break

        # merge sort
        n1 = nums1[count1]
        n2 = nums2[count2]
        if n1 > n2:
            nums.append(n2)
            count2 += 1
        else:
            nums.append(n1)
            count1 += 1

    middle = total_len // 2
    if total_len % 2 == 0:
        return (nums[middle - 1] + nums[middle]) / 2
    else:
        return nums[middle]


assert median_of_two_sorted_arrays([1, 3], []) == 2.0
assert median_of_two_sorted_arrays([1, 3], [2]) == 2.0
assert median_of_two_sorted_arrays([1, 2], [3, 4]) == 2.5
