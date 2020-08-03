/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_35
 * Data:        2020/7/19
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
示例 1:
输入: [1,3,5,6], 5
输出: 2
示例 2:
输入: [1,3,5,6], 2
输出: 1
示例 3:
输入: [1,3,5,6], 7
输出: 4
示例 4:
输入: [1,3,5,6], 0
输出: 0
 */
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        return helper(nums, target, 0, len - 1);
    }
    public int helper(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution_35 solution_35 = new Solution_35();
        System.out.println(solution_35.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
