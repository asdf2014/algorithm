//Given a sorted array nums, remove the duplicates in-place such that each eleme
//nt appear only once and return the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Example 1: 
//
// 
//Given nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums be
//ing 1 and 2 respectively.
//
//It doesn't matter what you leave beyond the returned length. 
//
// Example 2: 
//
// 
//Given nums = [0,0,1,1,1,2,2,3,3,4],
//
//Your function should return length = 5, with the first five elements of nums b
//eing modified to 0, 1, 2, 3, and 4 respectively.
//
//It doesn't matter what values are set beyond the returned length.
// 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means modification
// to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointer
//        return tp(nums);
        // solution 2
        return solution2(nums);
    }

    private int solution2(int[] nums) {
        int pos = nums.length > 0 ? 1 : 0;
        for (int n : nums) if ( nums[pos - 1] < n ) nums[pos++] = n;
        return pos;
    }

    private int tp(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pos == 0 || nums[pos - 1] != nums[i]) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
