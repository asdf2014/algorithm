import java.util.Arrays;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_34
 * Data:        2020/7/18
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Solution_34 {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || (len == 1 && nums[0] != target))
            return new int[]{-1, -1};
        if (len == 1 && nums[0] == target)
            return new int[]{0,0};
        int[] res = new int[]{-1,-1};
        binary_search(nums, target, 0, len -1, res);
        return res;
    }

    public static void binary_search(int[] nums, int target, int left, int right, int[] res){
        if (left > right) return;
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            res[0] = binary_left(nums, target, left, mid);
            if (res[0] == -1)
                res[0] = mid;
            res[1] = binary_right(nums, target, mid + 1, right);
            if (res[1] == -1)
                res[1] = mid;
            return;
        }
        if (nums[mid] > target)
            binary_search(nums, target, left, mid - 1, res);
        else
            binary_search(nums, target, mid + 1, right, res);
    }

    public static int binary_left(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target))
                return mid;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binary_right(int[] nums, int target, int left, int right){
        int len = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid + 1 == len || nums[mid + 1] > target))
                return mid;
            if (target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{0,0,1,1,1,2,4,4,4,4,5,5,5,6,8,8,9,9,10,10,10}, 8)));
    }
}
