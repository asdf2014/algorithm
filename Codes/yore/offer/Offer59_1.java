package com.yore.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jia bing wen
 * @date 2021/6/21 9:09
 * @description
 */
public class Offer59_1 {
    public static void main(String[] args) {
        Offer59_1 o = new Offer59_1();
        System.out.println(o.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            if (i >= k && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = queue.peek();
            }
        }
        return res;
    }
}
