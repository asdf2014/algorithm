package com.yore.easy;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/7/20 9:05
 * @description
 */
public class Number234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int begin = 0;
        int end = list.size() - 1;
        while (begin <= end) {
            if (!list.get(begin).equals(list.get(end))) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
