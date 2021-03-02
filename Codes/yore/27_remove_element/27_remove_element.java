class Solution {
    public int removeElement(int[] nums, int val) {
         int length = nums.length;
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}