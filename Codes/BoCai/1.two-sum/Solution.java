import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if( nums[0] + nums[1] == target){
            return new int[]{0,1}; 
        }
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 0);
        map.put(nums[1], 1);
        for(int a, i=2;i<nums.length;i++){
            a=nums[i];
            Integer index = map.get(target-a);
            if(null != index){
                return new int[]{index,i};
            }
            map.put(a, i);
        }
        throw new RuntimeException("No Solution !");
    }
}
// @lc code=end

