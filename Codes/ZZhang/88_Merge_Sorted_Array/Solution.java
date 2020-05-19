//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is greater or equal to 
//m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics Array Two Pointers


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //bf, 1ms, 14.09%
//        bf(nums1, m, nums2, n);
        // two pointer from back, 0ms, 100%
        tp1(nums1, m, nums2, n);
    }

    private void tp1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) nums1[p--] = nums1[p1--];
            else nums1[p--] = nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    private void bf(int[] nums1, int m, int[] nums2, int n) {
        // nums2 copy to nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // sort nums1
        Arrays.sort(nums1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
