/**
 * ClassName:   Solution_75
 * Data:        2020/7/29
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。
示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

 */
public class Solution_75 {
    public static void main(String[] args) {
        Solution_75 solution_75 = new Solution_75();
        int[] nums = new int[]{2,0,2,1,1,0};
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            solution_75.sortColors1(nums);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            solution_75.sortColors2(nums);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public void sortColors1(int[] nums) {
        int[] count = new int[]{0,0,0};
        for (int num : nums)
            count[num]++;
        for (int i = 0; i < count[0]; i++)
            nums[i] = 0;
        for (int i = count[0]; i < count[0] + count[1]; i++)
            nums[i] = 1;
        for (int i = count[0] + count[1]; i < count[0] + count[1] + count[2]; i++)
            nums[i] = 2;
    }

    public void sortColors2(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
