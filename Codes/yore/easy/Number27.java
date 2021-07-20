package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number27 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 5, 7, 4, 8, 4, 9};
//        int[] array = new int[]{3,2,2,3};
        System.out.println(removeElementTwo(array, 4));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 方法1： 遍历一遍数组，将不等于给定值的数字放在前面
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    /**
     * 方法2： 前后指针共同移动，直到会和
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementTwo(int[] nums, int val) {
        int end = nums.length - 1;
        int begin = 0;

        while (begin <= end) {
            while (begin <= end && nums[begin] != val) {
                begin++;
            }
            while (begin < end && nums[end] == val) {
                end--;
            }
            if (begin >= end) {
                return begin;
            }
            nums[begin] = nums[begin] ^ nums[end];
            nums[end] = nums[begin] ^ nums[end];
            nums[begin] = nums[begin] ^ nums[end];
            begin++;
            end--;
        }
        return begin ;
    }
}
