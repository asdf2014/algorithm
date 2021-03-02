/**
 * ClassName: com.ohmybug.firstTofifty.Solution_21
 * Date:      2020/4/15 1:17
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
 */
public class Solution_21 {
    public static void main(String[] args) {
        ListNode<Integer> list2 = new ListNode(0);
        list2.add(1);
        list2.add(2);
        list2.add(4);
        ListNode<Integer> list1 = new ListNode(0);
        list1.add(1);
        list1.add(3);
        list1.add(4);
        ListNode<Integer> list = mergeTwoLists(list1,list2);
        ListNode.show(list);
    }
    public static ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> newlist = new ListNode(0);
        ListNode<Integer> p = newlist;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return newlist.next;
    }
}
