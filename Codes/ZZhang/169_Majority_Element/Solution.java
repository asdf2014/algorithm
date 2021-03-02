//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation 
// 👍 3371 👎 225


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
//        return hashmap(nums);
//        return divideConquer(nums, 0, nums.length - 1);
        return sort(nums);
    }

    private int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    private int divideConquer(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];

        int mid = (hi - lo) / 2 + lo;

        int left = divideConquer(nums, lo, mid);
        int right = divideConquer(nums, mid + 1, hi);

        if (left == right) return left;
        int leftCount = countMaj(nums, left, lo, hi);
        int rightCount = countMaj(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countMaj(int[] nums, int target, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }

    private int hashmap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) map.put(val, 0);
            int count = map.get(val) + 1;
            if (count > nums.length / 2) return val;
            map.put(val, count);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
