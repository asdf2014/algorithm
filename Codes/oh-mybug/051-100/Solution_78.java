import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   Solution_78
 * Data:        2020/7/30
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Solution_78 {
    public static void main(String[] args) {
        Arrays.asList(new Solution_78().subsets(new int[]{1,2,3})).forEach(r -> {
            System.out.println(r.toString());
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= len; k++) {
            helper(nums, k, -1, res, new ArrayList<>());
        }
        return res;
    }

    public void helper(int[] nums, int k, int index, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 剪枝 ① index + 1（不重复） ② 剩下的要够组合成k个数
        for (int i = index + 1; i < nums.length; i++) {
            // n - i + 1 --> 还剩这么多数   k - temp.size() --> 还需要这么多数
            if (nums.length - i + 1 < k - temp.size())    // 供不应求
                break;
            temp.add(nums[i]);
            helper(nums, k, i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
