package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/6/15 7:57
 * @description
 */
public class Number852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length-2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1]) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        Number852 number852 = new Number852();
        System.out.println(number852.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
    }
}
