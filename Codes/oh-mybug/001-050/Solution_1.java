import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName: com.ohmybug.firstTofifty.Solution_1
 * Date:      2020/4/6 9:51
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的
那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
    给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Solution_1 {
    @Test
    public void test(){
        int[] nums = {3,3};
        System.out.println(twoSum(nums, 6)[0] + " " + twoSum(nums, 6)[1]);
    }
    /**
     * 将nums数组对应的target-nums[i]存入HashMap map中,key为target-nums[i]数值，value为index
     * 存入过程中，判断当前nums[i]是否已存在于map数组中，
     * 若存在，说明当前nums[i]值等于之前已存入的target-nums[j]，
     * 即返回当前nums[i]的index和target-nums[j]的index
     * @Function twoSum
     * @author   Oh_MyBug
     * @Date     2020/4/6 15:38
     * @param
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(nums[i])){
                return new int[]{i,(int)map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}