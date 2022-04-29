package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/29 9:45
 * @description 合并两个有序链表
 */
public class BM4 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode node = pre;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }

        return pre.next;
    }

    /**
     * 递归实现
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        if(list1.val <= list2.val){
            list1.next = Merge2(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge2(list1,list2.next);
            return list2;
        }
    }
}
