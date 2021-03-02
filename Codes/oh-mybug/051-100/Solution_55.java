/**
 * ClassName:   Solution_55
 * Data:        2020/7/23
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution_55 {
    // 回溯 浪费
//    public boolean canJump(int[] nums) {
//        int len = nums.length;
//        if (len == 0) return false;
//        boolean[] res = new boolean[]{false};
//        helper(nums, 0, res);
//        return res[0];
//    }
//
//    public void helper(int[] nums, int cur_loc, boolean[] res){
//        int len = nums.length;
//        if (cur_loc == len - 1){
//            res[0] = true;
//            return;
//        }
//        if (cur_loc > len - 1) return;
//        for (int i = 1; i <= nums[cur_loc]; i++){
//            helper(nums, cur_loc + i, res);
//            if (res[0]) return;
//        }
//    }

    // 贪心
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        if (len == 1) return true;
        int max = nums[0];
        int cur_loc = 0;
        while (cur_loc <= max){
            cur_loc ++;
            if (nums[cur_loc] + cur_loc >= len - 1) return true;
            max = Math.max(nums[cur_loc] + cur_loc, max);
        }
        return false;
    }
    public static void main(String[] args) {
        Solution_55 solution_55 = new Solution_55();
        System.out.println(solution_55.canJump(new int[]{1,0,1,0,4}));
    }
}
