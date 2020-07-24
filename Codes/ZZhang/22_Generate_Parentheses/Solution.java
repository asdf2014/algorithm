//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking 
// 👍 5340 👎 273


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        _recure(0, 0, n, "", res);
        return res;
    }

    private void _recure(int left, int right, int n, String s, List<String> res) {
        // terminate
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // process
        if (left < n) _recure(left + 1, right, n, s + "(", res);
        if (left > right) _recure( left, right + 1, n, s + ")", res);
        // reverse states
    }
}
//leetcode submit region end(Prohibit modification and deletion)
