package com.yore.medium;

import com.yore.base.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/27 8:50
 * @description
 */
public class Number817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode node = head;
        int count = 0;
        boolean flag = false;
        while (node != null) {
            if (set.contains(node.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                flag = false;
            }
            node = node.next;
        }
        return count;
    }
}
