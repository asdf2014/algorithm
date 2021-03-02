import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   Solution_90
 * Data:        2020/7/31
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Solution_90 {
    public static void main(String[] args) {
        Arrays.asList(new Solution_90().subsetsWithDup(new int[]{1, 2, 2})).forEach(l -> {
            System.out.println(l.toString());
        });
    }

    // 回溯
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= len; k++)  // k 个元素的集合
            helper(nums, -1, k, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int index, int k, List<List<Integer>> res, List<Integer> temp) {
        int len = nums.length;
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index + 1; i < len; i++) {
            // 剪枝 同层去重
            if (i > index + 1 && nums[i] == nums[i - 1])
                continue;
            // 剪枝 供小于求
            if (len - i + 1 < k - temp.size())
                continue;
            temp.add(nums[i]);
            helper(nums, i, k, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
