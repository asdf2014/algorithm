package com.yore.nowcoder;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/4/29 10:03
 * @description 合并K个有序链表 用优先级队列
 */
public class BM5 {
    public static void main(String[] args) {
        BM5 bm5 = new BM5();
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode h3 = new ListNode(3);
        ListNode h2 = new ListNode(2, h3);
        ListNode h1 = new ListNode(1, h2);

        ListNode l4 = new ListNode(7);
        ListNode l3 = new ListNode(6, l4);
        ListNode l2 = new ListNode(5, l3);
        ListNode l1 = new ListNode(4, l2);

        nodes.add(h1);
        nodes.add(l1);

        System.out.println(bm5.mergeKLists(nodes));
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode pre = new ListNode(-1);
        ListNode node = pre;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            while (list != null) {
                queue.offer(list);
                list = list.next;
            }
        }
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
        }
        return pre.next;
    }
}
