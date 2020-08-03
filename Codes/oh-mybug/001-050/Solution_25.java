/**
 * ClassName: com.ohmybug.firstTofifty.Solution_25
 * Date:      2020/4/15 11:37
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
示例：
    给你这个链表：1->2->3->4->5
    当 k = 2 时，应当返回: 2->1->4->3->5
    当 k = 3 时，应当返回: 3->2->1->4->5
说明：
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution_25 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
//        System.out.println(getLength(list1));
        ListNode.show(reverseKGroup(list1, 3));
    }

    /**
     * 来自https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     * 1.链表分区为已翻转部分+待翻转部分+未翻转部分
     * 2.每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
     * 3.需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
     * 4.初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
     * 5.经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
     * 6.翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
     * 7.特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
     * 8.时间复杂度为 O(n*K) 最好的情况为 O(n)O 最差的情况为 O(n^2)
     * 空间复杂度为 O(1) 除了几个必须的节点指针外，我们并没有占用其他空间
     * @param
     * @return
     * @Function swapPairs
     * @author Oh_MyBug
     * @Date 2020/4/15 11:04
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;

        ListNode lastend = newhead;
        ListNode currend = newhead;

        while (currend.next != null) {
            for (int i = 0; i < k && currend != null; i++) currend = currend.next;
            if (currend == null) break;
            ListNode start = lastend.next;
            ListNode next = currend.next;
            currend.next = null;
            lastend.next = reverse(start);
            start.next = next;
            lastend = start;

            currend = lastend;
        }
        return newhead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
