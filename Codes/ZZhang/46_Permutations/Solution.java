//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking 
// 👍 4328 👎 112


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        this.nums = nums;
        helper(new ArrayList<>());
        return res;
    }

    private void helper(ArrayList<Integer> subset) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        // process & drill down
        for (int i = 0; i < nums.length; i++) {
            if (subset.contains(nums[i])) continue;
            subset.add(nums[i]);
            helper(subset);
            // reverse state
            subset.remove(subset.size() - 1);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
