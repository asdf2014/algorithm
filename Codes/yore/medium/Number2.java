package com.yore.medium;


/**
 * create on 2019/1/24
 * * 1. 数字不越界条件下 可以执行成功
 * * 2. 支持大位数相加
 *
 * @author yore
 */
public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        Number2.ListNode l1 = number2.convertLink(564L);

        Number2.ListNode l2 = number2.convertLink(111L);
        Number2.ListNode result = number2.addTwoNumbers(l1, l2);
        System.out.println(number2.convertNumber(result));
    }

    /**
     * 解题思路：
     *   因为链表中是以逆序的形式存放数字，所以采用同时从表头开始遍历列表，用一个额外内存空间存储进位
     *   遍历的过程中做对应位加法运算（注意进位），同时构建结果链表元素
     *   遍历结束标志： 两个链表的next指针均位空
     * @param l1 数字1
     * @param l2 数字2
     * @return 相加结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointNode = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            pointNode.next = new ListNode(sum % 10);
            pointNode = pointNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            pointNode.next = new ListNode(carry);
        }
        return result.next;
    }


    public long convertNumber(ListNode node) {
        long number = node.val;
        int cale = 1;
        while (node.next != null) {
            node = node.next;
            int val = node.val;
            number += (val * Math.pow(10, cale++));
        }
        return number;
    }

    public ListNode convertLink(long number) {
        if (number == 0) {
            return new ListNode(0);
        }
        ListNode node = new ListNode((int) (number % 10));
        ListNode nodePoint = node;
        number /= 10;

        while (number != 0) {
            int val = (int) (number % 10);
            ListNode listNode = new ListNode(val);
            nodePoint.next = listNode;
            nodePoint = listNode;
            number /= 10;
        }
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
