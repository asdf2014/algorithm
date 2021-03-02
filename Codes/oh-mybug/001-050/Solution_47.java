import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution_47
 * Date:      2020/7/20 17:28
 * author:    Oh_MyBug
 * version:   V1.0
 */

/*
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res){
        int len = nums.length;
        if (index == len){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == Integer.MAX_VALUE)
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            int temp_num = nums[i];
            nums[i] = Integer.MAX_VALUE;
            helper(nums, index + 1, temp, res);
            temp.remove(temp.size() - 1);
            nums[i] = temp_num;
        }
    }

    public static void main(String[] args) {
        Solution_47 solution_47 = new Solution_47();
        System.out.println(solution_47.permuteUnique(new int[]{1,1,3}).toString());
    }
}
