package com.yore.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yore
 * @date 2021/11/11 10:15
 * @description
 */
public class Number239 {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> id = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
                id.pollLast();
            }
            queue.offerLast(nums[i]);
            id.offerLast(i);

            while(i - id.peekFirst() >= k){
                queue.pollFirst();
                id.pollFirst();
            }
            if (i >= k-1) {
                res[index++] = queue.peekFirst();
            }
        }
        return res;
    }
}
