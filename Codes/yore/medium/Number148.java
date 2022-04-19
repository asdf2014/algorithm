package com.yore.medium;

import com.yore.base.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/7/27 10:38
 * @description
 */
public class Number148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        ListNode pre = new ListNode(-1);
        ListNode h = pre;
        for (Integer integer : list) {
            ListNode tmp = new ListNode(integer);
            pre.next = tmp;
            pre = tmp;
        }
        return h.next;
    }
}
