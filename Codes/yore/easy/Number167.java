package com.yore.easy;

/**
 * @author Yore
 * @date 2021/9/18 16:25
 * @description
 */
public class Number167 {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{-1, 0}, -1));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if ((numbers[left] + numbers[right]) > target) {
                right--;
            } else if ((numbers[left] + numbers[right]) < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return null;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
