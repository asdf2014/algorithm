def threeSum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    nums1 = sorted(nums)
    size = len(nums1)
    l = []
    for i in range(0, size):
        j = i + 1
        k = size - 1
        while j < k:
            while j < k and nums1[k] + nums1[j] > -nums1[i]:
                k -= 1
            while j < k and nums1[k] + nums1[j] < -nums1[i]:
                j += 1
            while j < k and nums1[j] + nums1[k] == -nums1[i]:
                if [nums1[i], nums1[j], nums1[k]] not in l:
                    l.append([nums1[i], nums1[j], nums1[k]])

                k -= 1
    return l


if __name__ == "__main__":
    print(threeSum([-1, 0, 1, 2, -1, -4]))
