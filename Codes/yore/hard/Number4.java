package com.yore.hard;

import java.util.PriorityQueue;

/**
 * create on 2019/7/6
 * 4_寻找两个有序数组的中位数
 * <p> 前提： 不会出现两个数组同时为空的情况
 * 要求： 时间复杂度为 O(log(m + n))
 *
 * @author yore
 */
@SuppressWarnings("all")
public class Number4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * 解题思路：
     * 时间复杂度要求 log(m+n) 想到采用折半查找的方式
     * <p>
     * 题目给定的两个数组分别是有序的，我们要找的就是两个数组合并后第k大的数字(这里讨论的k从1开始)
     * k的怎么来的？
     * ① 若m+n为偶数 则 k其实是中间两个位置之间，中位数为这两个数的平均值 (m+n+1)/2 < k < (m+n+2)/2
     * ② 若m+n为奇数 则 k就取中间位置  k = (m+n+1)/2
     * <p>
     * 如何找到k：
     * 采用二分查找的方式，从当前的两个数组中逐步排除较小的数字
     * 每次从各数组中取出k/2个元素进行比较，较小的那一部分就可以去掉，因为k不会出现在其中，然后k减半，对剩余部分继续查找，直到k减为1
     * 代码待优化。。。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean even = (len1 + len2) % 2 == 0;
        //特殊情况： 存在一个数组为空
        if (len1 == 0) {
            return len2 % 2 == 0 ? (nums2[len2 / 2] + nums2[(len2 - 1) / 2]) / 2.0 : nums2[len2 / 2];
        } else if (len2 == 0) {
            return len1 % 2 == 0 ? (nums1[len1 / 2] + nums1[(len1 - 1) / 2]) / 2.0 : nums1[len1 / 2];
        }
        int k = (len1 + len2 + 1) / 2;
        int m = k / 2;
        int curIndex_1 = -1, curIndex_2 = -1;//为保证每一次循环所增加的差值保持一致，初始下标置为-1
        int i, j;
        while (k > 1) {
            if (m + curIndex_1 >= len1 - 1 || m + curIndex_2 >= len2 - 1) {
                m = Math.min(len1 - 1 - curIndex_1, len2 - curIndex_2 - 1);
            }
            i = Math.min(len1 - 1, m + curIndex_1);
            j = Math.min(len2 - 1, m + curIndex_2);
            if (nums1[i] <= nums2[j]) {
                if (i == len1 - 1) {
                    return handleSpecialCase(even, nums2, curIndex_2 + k - m);
                } else {
                    curIndex_1 = i;
                }
            } else {
                if (j == len2 - 1) {
                    return handleSpecialCase(even, nums1, curIndex_1 + k - m);
                } else {
                    curIndex_2 = j;
                }
            }
            k -= m;
            m = k / 2;
        }
        ++curIndex_1;
        ++curIndex_2;
        if (even) {
            int a = Math.min(nums1[curIndex_1], nums2[curIndex_2]);
            int b = 0;
            if (a == nums1[curIndex_1]) {
                if (curIndex_1 == len1 - 1) {
                    b = nums2[curIndex_2];
                } else {
                    b = Math.min(nums1[curIndex_1 + 1], nums2[curIndex_2]);
                }
            } else {
                if (curIndex_2 == len2 - 1) {
                    b = nums1[curIndex_1];
                } else {
                    b = Math.min(nums1[curIndex_1], nums2[curIndex_2 + 1]);
                }
            }
            return (a + b) / 2.0;
        } else {
            return Math.min(nums1[curIndex_1], nums2[curIndex_2]);
        }
    }

    /**
     * 特殊情况：若两个数组长度相差较大，则在查找过程中可能会出现一个数组已经全部被排除的可能
     * 这时就可以根据数据直接计算出中位数
     */
    public static double handleSpecialCase(boolean even, int[] num, int i) {
        if (even) {
            return (num[i] + num[i + 1]) / 2.0;
        }
        return num[i];
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> heapA = new PriorityQueue<>();
        PriorityQueue<Integer> heapB = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums1) {
            if (heapA.size() != heapB.size()) {
                heapA.add(num);
                heapB.add(heapA.poll());
            } else {
                heapB.add(num);
                heapA.add(heapB.poll());
            }
        }
        for (int num : nums2) {
            if (heapA.size() != heapB.size()) {
                heapA.add(num);
                heapB.add(heapA.poll());
            } else {
                heapB.add(num);
                heapA.add(heapB.poll());
            }
        }
        return heapA.size() == heapB.size() ? (heapA.peek()  + heapB.peek()) / 2.0: heapA.peek() * 1.0;
    }
}
