import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_40
 * Data:        2020/7/19
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class Solution_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] candidates, int target, int index, int sum, List<Integer> temp, List<List<Integer>> res){
        if (sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                break;
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            temp.add(candidates[i]);
            helper(candidates, target, i + 1, sum + candidates[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_40 solution_40 = new Solution_40();
        System.out.println(solution_40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).toString());
    }
}
