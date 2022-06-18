package com.yore.offer;

import com.yore.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jia bing wen
 * @date 2021/5/28 8:37
 * @description
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
