def findMedianSortedArrays(nums1, nums2):
    if len(nums1) == 0:
        return nums2[(len(nums2) - 1) / 2]


if __name__ == "__main__":
    print findMedianSortedArrays([1, 2, 3, 5], [4, 6, 7, 8, 9])
