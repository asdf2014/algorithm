package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/9 21:23
 * @description
 */
public class Offer006 {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1;
        int left = 0;
        int sum = 0;
        while(left < right){
            sum = numbers[left] + numbers[right];
            if(sum  == target){
                return new int[]{left,right};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
