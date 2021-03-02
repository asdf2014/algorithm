import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_39
 * Data:        2020/7/19
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class Solution_39 {
    // 回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, 0, res);
        return res;
    }

    public void helper(int[] candidates, int target, List<Integer> temp, int sum, int index, List<List<Integer>> res){
        if (sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[index] > target)
                break;
            temp.add(candidates[i]);
            helper(candidates, target, temp, sum + candidates[i], i, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_39 solution_39 = new Solution_39();
        System.out.println(solution_39.combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }
}
