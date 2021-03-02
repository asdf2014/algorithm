//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Follow up: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10^4 
// It's guaranteed that nums[i] fits in a 32 bit-signed integer. 
// k >= 0 
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        // so1, time:O(n * k), 190ms, 18.8%; space: O(1)
//        so1(nums, k);
        // so2, time: O(n), 100%; space: O(n)
//        so2(nums, k);
        // so3, time:O(n), 100%; space: O(1)
        so3(nums, k);
    }

    // https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
    private void so3(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        k = k % len;
        for (int start = 0; count < len; start++) {
            int cur = start;
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                // 角落
                int temp = nums[next];
                nums[next] = pre;
                cur = next;
                pre = temp;
                count++;
            } while (start != cur);
        }
    }

    private void so2(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = arr[i];
        }
    }

    private void so1(int[] nums, int k) {
        int count = 0;
        int len = nums.length - 1;
        while (count < k) {
            int temp = nums[len];
            for (int i = len - 1; i >= 0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
            count++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
