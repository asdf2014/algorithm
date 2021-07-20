package com.yore.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * create on 2019/1/24
 *  1_两数之和
 * @author yore
 */
public class Number1 {
    /**
     * 方案1 时间复杂度o(n^2) 空间复杂度o(1)
     *
     * @param numbers 输入数组
     * @param target  目标值
     * @return int[]
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    result[count++] = i;
                    result[count] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 方案2  时间复杂度o(n)  空间复杂度o(n)
     *    解题思路：
     *      遍历数组，先计算出目标值与当前索引下数据的差值，然后查看map中是否包含该值
     *
     *       (1) 若包含，即定位到结果
     *       (2) 若不包含，则将该差值作key  对应下标作为value存储在map中，供后续查找
     * @param numbers 输入数组
     * @param target  目标值
     * @return int[]
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
