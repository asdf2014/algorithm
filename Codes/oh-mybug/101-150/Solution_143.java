/**
 * ClassName: Solution_143
 * Date:      2020/4/12 23:35
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
    给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Solution_143 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.add(6);
        reorderList(list);
        while (list != null){
            System.out.println(list);
            list = list.next;
        }
    }
    /**
     * 核心思想:
     *  ① 找到中点
     *  ② 反转后半链表
     *  ③ 使用两个游标重排链表
     * @Function TODO
     * @author   Oh_MyBug
     * @Date     2020/4/13 0:58
     * @param
     * @return
     */
    public static void reorderList(ListNode head) {
        if (head == null)
            return;
        int len = getLength(head);
        if (len == 1 || len == 2)
            return;
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode temp;
        int end = len%2 == 0 ? len/2-1 : len/2;
        for (int i = 0; i < end; i++){
            cur2 = cur2.next;
        }
        cur2.next = reverse(cur2.next);
        while (end -- != 0) {
            temp = cur2.next;
            cur2.next = temp.next;
            temp.next = cur1.next;
            cur1.next = temp;
            cur1 = cur1.next.next;
        }
    }
    /**
     * 获取链表长度
     * @Function getLength
     * @author   Oh_MyBug
     * @Date     2020/4/13 0:59
     * @param
     * @return
     */
    public static int getLength(ListNode head){
        int count = 0;
        while (head != null){
            count ++;
            head = head.next;
        }
        return count;
    }
    /**
     * 反转链表
     * @Function reverse
     * @author   Oh_MyBug
     * @Date     2020/4/13 0:59
     * @param
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode p = new ListNode(0);
        ListNode cur;
        p.next = head;
        while (head.next != null){
            cur = head.next;
            head.next = cur.next;
            cur.next = p.next;
            p.next = cur;
        }
        return p.next;
    }
}
