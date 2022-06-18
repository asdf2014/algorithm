package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/21 10:09
 * @description
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
                i++;
                j--;
            } else {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Offer21 o = new Offer21();
        System.out.println(o.exchange(new int[]{1, 3, 5}));
    }
}
