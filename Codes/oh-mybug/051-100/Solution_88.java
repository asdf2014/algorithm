import java.util.Arrays;

/**
 * ClassName:   Solution_88
 * Data:        2020/7/30
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
 */
public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = 0, cur2 = 0, cur = 0;
        int[] temp_num1 = new int[m];
        for (int i = 0; i < m; i++)
            temp_num1[i] = nums1[i];
        while (cur1 < m && cur2 < n) {
            if (temp_num1[cur1] > nums2[cur2])
                nums1[cur++] = nums2[cur2++];
            else
                nums1[cur++] = temp_num1[cur1++];
        }
        while (cur1 < m)
            nums1[cur++] = temp_num1[cur1++];
        while (cur2 < n)
            nums1[cur++] = nums2[cur2++];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;
        new Solution_88().merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
