/**
 * ClassName: com.ohmybug.firstTofifty.Solution_24
 * Date:      2020/4/15 10:06
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例:
    给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution_24 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
//        list1.add(6);
        ListNode.show(swapPairs(list1));
    }
    /**
     * 补充：链表的反转的思想
     *       比如有一个链表head，将头结点head的下一个结点摘下，然后放在head的前面，
     *       然后把该结点作为新的头部newhead（初始化为head），重复这个步骤，
     *       直到head的下一个结点为空
     *       com.ohmybug.fifty_3.ListNode newhead = head;
     *       com.ohmybug.fifty_3.ListNode temp = null;
     * 代码：while(head.next != null) {
     *            temp = head.next;
     *            head.next = temp.next;
     *            temp.next = newhead;
     *            newhead = temp;
     *       }
     * 本题思想：将head链表看作每2个结点为一个小链表lists[i](即把head分为length/2+1个链表lists)，
     *           然后对小链表进行反转，时间复杂度O(n)，空间复杂度O(1)
     * 具体说明：设置两个游标cur1和cur2、一个当前小链表头结点newhead还有一个临时结点temp
     *  假设当前更新的链表为lists[i]
     *  ① cur2的作用：作为上一条链表lists[i-1]的尾部，用于每次更新当前链表newhead时重新连接newhead；初始化为head
     *  ② cur1的作用：作为当前小链表lists[i]的头部，相当于反转链表代码中的head；初始化为head
     *  ③ newhead的作用：作为当前小链表lists[i]的新头部，相当于反转链表代码中的newhead；初始化为head；
     *  注意：当反转第一条小链表lists[0]的时候，cur1没有作用，因为lists[0]是“根链表”
     * @Function swapPairs
     * @author   Oh_MyBug
     * @Date     2020/4/15 11:04
     * @param
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        int k = 1;
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode newhead = head;
        ListNode temp = null;
        boolean start = false;  // start为false表示当前小链表是lists[0]，否则为lists[i](i不等于0)
        int count = 0;
        while (true){
            if (cur1.next == null) break;
            // 当前小链表lists[i]已反转完毕，进入下一个小链表lists[i+1]，
            // 即更新newhead、cur1、cur2
            if (count == k){
                start = true;
                cur2 = cur1;
                cur1 = cur1.next;
                count = 0;
                newhead = cur1;
            }
            if (cur1.next == null) break;
            count++;
            // 反转链表
            temp = cur1.next;
            cur1.next = temp.next;
            temp.next = newhead;
            newhead = temp;
            // 如果是首链表lists[0]，要更新head
            if (!start){
                head = newhead;
            }
            // 如果非首链表lists[i]，因为newhead更新了，所以lists[i-1]要重新连接list[i]
            else {
                cur2.next = newhead;
            }
        }
        return head;
    }
}

