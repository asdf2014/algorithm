//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking 
// 👍 2125 👎 63


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        this.nums = nums;
        boolean[] visited = new boolean[nums.length];

        helper(new ArrayList<>(), visited);

        return res;
    }

    private void helper(ArrayList<Integer> subset, boolean[] visited) {
        // terminator
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // process & drill down
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && ! visited[i - 1]) continue;

            subset.add(nums[i]);
            visited[i] = true;
            helper(subset, visited);
            // reverse state
            visited[i] = false;
            subset.remove(subset.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
