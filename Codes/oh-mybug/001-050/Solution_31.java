import java.util.Arrays;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_31
 * Data:        2020/7/17
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
31. 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution_31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length, temp;
        if (len == 0 || len == 1) return;
        // 如果最后两个数字是否升序，改为降序即为下一个排列
        if (nums[len - 2] < nums[len - 1]){
            temp = nums[len - 1];
            nums[len - 1] = nums[len - 2];
            nums[len - 2] = temp;
            return;
        }

        // 如果nums最后两个数字降序且只有两个元素，则不存在下一个更大的排列，则将nums数组升序排列
        if (len == 2){
            Arrays.sort(nums);
            return;
        }

        // 如果最后两个数字是降序，则再往前多加一个数字，
        // 判断最后三个字符是否非降序，以此类推，直到找到非降序
        int index = len - 2;
        while (nums[index - 1] >= nums[index]){
            -- index;
            // 如果nums数组是降序，则不存在下一个更大的排列，则将nums数组升序排列
            if (index == 0) {
                Arrays.sort(nums);
                return;
            }
        }

        // 在[index, len)区间找到比nums[index-1]的下一个大值max_next以及对应索引max_next_index
        int max_next = nums[index], max_next_index = index;
        for (int i = index; i < len; i++) {
            temp = Math.max(nums[index - 1], nums[i]);  // 比nums[index-1]大
            max_next = temp != nums[index - 1] ? Math.min(temp, max_next) : max_next;        // 在所有比nums[index-1]大的数中最小
            max_next_index = max_next == nums[i] ? i : max_next_index;
        }

        // 将index-1对应数值与min_index进行交换
        temp = nums[index - 1];
        nums[index - 1] = nums[max_next_index];
        nums[max_next_index] = temp;

        // 对[index, len)区间的数组进行升序排序
        Arrays.sort(nums, index, len);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
