public int removeDuplicates(int[] nums) {
    int length = nums.length;
    if (length <= 1) {
        return length;
    }
    int i = 0, j = 0;
    while (j < length - 1) {
        if (nums[j] != nums[++j]) {
            nums[++i] = nums[j];
        }
    }
    return i + 1;
}
