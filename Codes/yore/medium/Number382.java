package com.yore.medium;

import java.security.SecureRandom;
import java.util.HashMap;

/**
 * @author Yore
 * @date 2022/1/16 9:30
 * @description
 */
public class Number382 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int size;
    public HashMap<Integer, Integer> map = new HashMap<>();

    public Number382(ListNode head) {
        this.size = 0;
        ListNode node = head;
        while (node != null) {
            map.put(size++, node.val);
            node = node.next;
        }
    }

    public int getRandom() {
        SecureRandom rand = new SecureRandom();
        return map.get(rand.nextInt(this.size));
    }
}
