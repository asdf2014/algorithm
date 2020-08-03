import java.util.Arrays;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_16
 * Data:        2020/7/14
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 */
public class Solution_16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])    continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)  return target;
                if (Math.abs(sum - target) < Math.abs(best - target))
                    best = sum;
                if (sum > target) {
                    -- k;
                    while (j < k && nums[k] == nums[k+1])
                        --k;
                } else {
                    ++ j;
                    while (j < k && nums[j] == nums[j-1])
                        ++ j;
                }
            }
        }
        return best;
    }
    public static void main(String[] args) {

        System.out.println(threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
    }
}
