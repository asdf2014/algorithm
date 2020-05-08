//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics Array Two Pointers


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    // BF; O(n^3), 超时
//        return bf(nums);

    // advanced 2sum; O(n^2)
    return tp(nums);

  }

  private List<List<Integer>> tp(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1]== nums[i]) continue;

      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int s = nums[i] + nums[left] + nums[right];

        if (s < 0) {
          left++;
          while (left < right && nums[left-1] == nums[left]) left++;
        } else if (s > 0) {
          right--;
          while (left < right && nums[right+1] == nums[right]) right--;
        } else {
          List<Integer> value = List.of(nums[i], nums[left], nums[right]);
          res.add(value);

          left++;
          right--;
          while (left < right && nums[left-1] == nums[left]) left++;
          while (left < right && nums[right+1] == nums[right]) right--;
        }
      }
    }
    return res;
  }

  private List<List<Integer>> bf(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List value = List.of(nums[i], nums[j], nums[k]);
            result.add(value);
          }
        }
      }
    }
    return new ArrayList<>(result);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
