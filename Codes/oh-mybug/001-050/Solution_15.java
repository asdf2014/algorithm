import java.util.*;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_15
 * Data:        2020/7/13
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */
public class Solution_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) return res;
        Arrays.sort(nums);
        int min, max;
        for (int i = 0; i < len-2; ++i) {

            min = nums[i] + nums[i+1] + nums[i+2];
            if (min > 0) continue;
            max = nums[i] + nums[len-1] + nums[len-2];
            if (max < 0) continue;

            if (i > 0 && nums[i] == nums[i - 1])    continue;
            int k = len - 1;
            int target = -nums[i];
            for (int j = i + 1; j < len; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1])    continue;
                while (j < k && nums[j] + nums[k] > target)
                    --k;
                if (j == k)     break;
                if (nums[j] + nums[k] == target)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    }
}
