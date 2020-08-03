import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_18
 * Data:        2020/7/14
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Solution_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4) return res;
        Arrays.sort(nums);
        int min, max;
        for (int i = 0; i < len-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            min = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (min > target)   continue;
            max = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
            if (max < target)   continue;

            for (int j = i + 1; j < len-2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                min = nums[i] + nums[j] + nums[j+1] + nums[j+2];
                if (min > target)   continue;
                max = nums[i] + nums[j] + nums[len-1] + nums[len-2];
                if (max < target)   continue;

                int l = len - 1;

                for (int k = j + 1; k < len-1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) continue;
                    while (k < l && nums[i] + nums[j] + nums[k] + nums[l] > target)
                        -- l;
                    if (k == l) break;
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
    }
}
