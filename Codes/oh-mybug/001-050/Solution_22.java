import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_22
 * Data:        2020/7/15
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

 */
public class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("", n, n, res);
        return res;
    }

    // 深度遍历 + 剪枝
    public void helper(String temp, int left_n, int right_n, List<String> res){
        if (left_n == 0 && right_n == 0) {
            res.add(temp);
        } else {
            if (left_n > right_n) return;
            if (left_n != 0)
                helper(temp + "(", left_n - 1, right_n, res);
            if (right_n != 0)
                helper(temp + ")", left_n, right_n - 1, res);
        }
    }

    public static void main(String[] args) {
        Solution_22 solution_22 = new Solution_22();
        System.out.println(solution_22.generateParenthesis(4).toString());
    }
}
