package com.leetcode;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
class Solution0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        for(int i=0;i<nums1.length;i++) {
            merged[i] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++) {
            merged[i + nums1.length] = nums2[i];
        }
        int[] temp = new int[merged.length];
        sort(merged, 0, merged.length - 1, temp);
        if(merged.length % 2 == 0) {
           return (double)((merged[merged.length/2 - 1] + merged[merged.length/2]) / 2.0);
        }
        return (double)merged[merged.length/2];
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while(j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}