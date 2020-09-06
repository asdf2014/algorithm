//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 4016 👎 85


//def subsets(self, nums: List[int]) -> List[List[int]]:
//    res = [[]]
//    for i in nums:
//    res = res + [[i] + num for num in res]
//    return res



import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
//        return iter(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        res.add(subset);
        preorder(nums, 0, res, subset);
        return res;
    }

    private void preorder(int[] nums, int level, List<List<Integer>> res, List<Integer> subset) {
        if (level>= nums.length) return;

        subset = new LinkedList<>(subset);
        res.add(subset);
        preorder(nums, level + 1, res, subset);
        subset.add(nums[level]);
        preorder(nums, level + 1, res, subset);
    }


    private List<List<Integer>> iter(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new LinkedList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
