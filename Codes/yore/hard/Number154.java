package com.yore.hard;

/**
 * @author jia bing wen
 * @date 2021/6/2 9:15
 * @description
 */
public class Number154 {
    public static void main(String[] args) {
        Number154 number = new Number154();
        System.out.println(number.findMin(new int[]{2,2,2,3,4,0,0,1,2}));
    }
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;  //防止溢出
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
