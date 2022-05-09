package com.yore.nowcoder;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/5 11:23
 * @description
 */
public class BM13 {
    public boolean isPail(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
