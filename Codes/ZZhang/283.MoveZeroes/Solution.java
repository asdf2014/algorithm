//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void moveZeroes(int[] nums) {
        // O(n)
//        snowBall(nums);
        // two pointer; O(n)
        tp(nums);
    }

    private void snowBall(int[] nums) {
        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowballSize++;
            } else if (snowballSize > 0) {
                nums[i-snowballSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

    private void tp(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = nums[i];
                p++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
