/**
 * ClassName: com.ohmybug.Solution_82
 * Date:      2020/4/15 22:21
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
示例 1:
    输入: 1->2->3->3->4->4->5
    输出: 1->2->5
示例 2:
    输入: 1->1->1->2->3
    输出: 2->3
 */
public class Solution_82 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        ListNode.show(deleteDuplicates(list));
    }
    /**
     * 思想：设置两个游标curr和pre还有一个“哨兵”sameNode
     * ① 首先定义一个“不带值”的头结点newhead链接在head链表
     * ② pre的作用：指向最近的不重复的结点；初始化为newhead
     * ③ curr的作用：用于遍历链表，判断当前curr和下一个结点是否相等；初始化为head
     * ④ sameNode的作用：当curr.val == curr.next.val时，记录下该结点的值，之后判断pre
     *    的下一个结点是否和该结点相同，若是，则删除pre的下个节点，直到不是，然后sameNode
     *    设置为null；sameNode初始化为null；
     * @Function deleteDuplicates
     * @author   Oh_MyBug
     * @Date     2020/4/15 22:56
     * @param
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode curr = newhead.next;
        ListNode sameNode = null;
        while (curr != null){
            if (sameNode != null){
                if (pre.next.val == sameNode.val){
                    pre.next = curr.next;
                    curr = pre.next;
                    continue;
                }
                if (pre.next.val != sameNode.val){
                    sameNode = null;
                }
            }
            if (curr.next == null) break;
            if (curr.val == curr.next.val){
                sameNode = new ListNode(curr.val);
            } else {
                curr = curr.next;
                pre = pre.next;
            }

        }
        return newhead.next;
    }
}
