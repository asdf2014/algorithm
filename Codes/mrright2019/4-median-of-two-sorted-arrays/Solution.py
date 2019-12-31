class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        media = []
        n, i, j = 0, 0, 0
        while n < (len(nums1) + len(nums2)) / 2:
            if i < len(nums1) and (j >= len(nums2) or nums1[i] < nums2[j]):
                media.append(nums1[i])
                i += 1
            else:
                media.append(nums2[j])
                j += 1
            n += 1
        if (len(nums1) + len(nums2)) % 2:
            if i >= len(nums1):
                return nums2[j]
            elif j >= len(nums2):
                return nums1[i]
            else:
                return min([nums1[i], nums2[j]])
        else:
            if i >= len(nums1):
                media.append(nums2[j])
            elif j >= len(nums2):
                media.append(nums1[i])
            else:
                media.append(min([nums1[i], nums2[j]]))
            return float(media[-2] + media[-1]) / 2.0
