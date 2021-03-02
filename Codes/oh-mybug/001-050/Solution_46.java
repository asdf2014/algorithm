import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution_46
 * Date:      2020/7/20 16:54
 * author:    Oh_MyBug
 * version:   V1.0
 */

/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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
            temp.add(nums[i]);
            int temp_num = nums[i];
            nums[i] = Integer.MAX_VALUE;
            helper(nums, index + 1, temp, res);
            temp.remove(temp.size() - 1);
            nums[i] = temp_num;
        }
    }

    public static void main(String[] args) {
        Solution_46 solution_46 = new Solution_46();
        System.out.println(solution_46.permute(new int[]{1,2,3}).toString());
    }
}
