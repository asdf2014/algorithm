package com.yore.base;

/**
 * @author jia bing wen
 * @date 2021/5/7 20:48
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
