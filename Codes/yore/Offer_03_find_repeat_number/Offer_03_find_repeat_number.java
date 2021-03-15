/**
 * 采用哈希表存储数值，实现简单，时间复杂度高
 *
 * @param nums
 * @return
 */
public int findRepeatNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int num : nums) {
        if (map.containsKey(num)) {
            return num;
        } else {
            map.put(num, 1);
        }
    }
    return -1;
}

/**
 * 原地置换的思路，因为数字范围为0~n-1， 将数字i放在数组下标为i的位置
 *
 * @param nums
 * @return
 */
public int findRepeatNumber1(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] != i) {
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            nums[i] = nums[i] ^ nums[nums[i]];
            nums[nums[i]] = nums[nums[i]] ^ nums[i];
            nums[i] = nums[i] ^ nums[nums[i]];
        }
    }
    return -1;
}