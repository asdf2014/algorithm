//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// Follow up: The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3481 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        int len_a = nums1.size();
        int len_b = nums2.size();
        int sum = len_a + len_b;
        if (len_a != 0 && len_b != 0)
        {
            if (nums1[len_a - 1] <= nums2[0]) {
                if (sum % 2 != 0) {
                    if (len_a > sum / 2) {
                        return nums1[sum / 2];
                    } else {
                        return nums2[sum / 2 - len_a];
                    }
                } else {
                    if (len_a > sum / 2) {
                        return (nums1[sum / 2] + nums1[sum / 2 - 1]) / 2.0;
                    } else if (len_a < sum / 2) {
                        return (nums2[sum / 2 - len_a] + nums2[sum / 2 - len_a - 1]) / 2.0;
                    } else {
                        return (nums1[len_a - 1] + nums2[0]) / 2.0;
                    }
                }
            }
            if (nums2[len_b - 1] < nums1[0]) {
                if (sum % 2 != 0) {
                    if (len_a > sum / 2) {
                        return nums1[sum / 2 - len_b];
                    } else {
                        return nums2[sum / 2];
                    }
                } else {
                    if (len_a > sum / 2) {
                        return (nums1[sum / 2 - len_b] + nums1[sum / 2 - len_b - 1]) / 2.0;
                    } else if (len_a < sum / 2) {
                        return (nums2[sum / 2] + nums2[sum / 2 - 1]) / 2.0;
                    } else {
                        return (nums1[0] + nums2[len_b - 1]) / 2.0;
                    }
                }
            }
        }
        // 区间有交叉
        int total = len_a + len_b;
        while (total != 1 && total != 2) {
            // 去掉一个最大值, 去掉一个最小值
            if (nums1.size() == 0) {
                auto i = nums2.begin();
                nums2.erase(i);
            } else if (nums2.size() == 0) {
                auto i = nums1.begin();
                nums1.erase(i);
            } else if (nums1[0] <= nums2[0]) {
                auto i = nums1.begin();
                nums1.erase(i);
            } else {
                auto i = nums2.begin();
                nums2.erase(i);
            }

            if (nums1.size() == 0) {
                nums2.pop_back();
            } else if (nums2.size() == 0) {
                nums1.pop_back();
            } else if (nums1[nums1.size() - 1] >= nums2[nums2.size() - 1]) {
                nums1.pop_back();
            } else {
                nums2.pop_back();
            }
            total -= 2;
        }
        if (total == 1) {
            return nums1.size() > nums2.size() ? nums1[0] : nums2[0];
        } else {
            if (nums1.size() == 0) {
                return (nums2[0] + nums2[1]) / 2.0;
            } else if (nums1.size() == 1) {
                return (nums1[0] + nums2[0]) / 2.0;
            } else {
                return (nums1[0] + nums1[1]) / 2.0;
            }
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
