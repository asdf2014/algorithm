import java.util.*;

public class Test {
    public int[] twoSum(int[] nums, int target) {
        // 使用哈希表来解决
        // 设置一个map用于存储对应的值以及它们的下标
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 设置一个结果数组res
        int[] res = new int[2];

        // 遍历这个数组
        for (int i = 0; i < nums.length; i++) {
            // 获得一个目标值
            int num = target - nums[i];
            // 如果之前有这个值，就将结果放到res中，返回就好了
            if (map.containsKey(num)) {
                res[0] = map.get(num);
                res[1] = i;
                return res;
            } else {// 否则就把这个值放进map中
                map.put(nums[i], i);
            }
        }

        // 如果没有，返回null
        return null;
    }