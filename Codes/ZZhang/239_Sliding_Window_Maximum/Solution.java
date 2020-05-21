//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics Heap Sliding Window


import static java.lang.Math.max;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // bf. O(n*k), Time Limit Exceeded
//        return bf(nums, k);
        // deque
        return deque(nums, k);
        
    }

    private int[] deque(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length-k+1];
        for(int i = 0;i < nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peek() <= i-k){
                queue.poll();
            }
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;

    }

    private int[] bf(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int maxWin = nums[i];
            for (int j = i; j < i+k; j++) {
                maxWin = Math.max(nums[j], maxWin);
            }
            res[i] = maxWin;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
