//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking 
// 👍 1532 👎 69


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        helper(1, new ArrayList<Integer>());
        return res;
    }

    private void helper(int start, ArrayList<Integer> subset) {
        // terminator
        if (subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // process & drill down
        for (int i = start; i <= n; i++) {
            subset.add(i);
            helper(i + 1, subset);
            // reverse state
            subset.remove(subset.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
