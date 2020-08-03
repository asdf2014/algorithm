/**
 * ClassName: Solution_234
 * Date:      2020/4/15 0:24
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
请判断一个链表是否为回文链表。

示例 1:
    输入: 1->2
    输出: false
示例 2:
    输入: 1->2->2->1
    输出: true
进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution_234 {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        System.out.println(isPalindrome(list));
    }
    /**
     * ① 找链表中心
     * ② 反转中心后链表
     * ③ 比较
     * @Function isPalindrome
     * @author   Oh_MyBug
     * @Date     2020/4/15 1:12
     * @param
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode center = center(head);
        if (center.next == null) return true;
        ListNode after = reverse(center.next);
        ListNode a = after;
        ListNode p = head;
        while (a != null){
            if (a.val != p.val) return false;
            a = a.next;
            p = p.next;
        }
        return true;
    }
    /**
     * 反转链表
     * @Function reverse
     * @author   Oh_MyBug
     * @Date     2020/4/15 1:12
     * @param
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode temp;
        ListNode cur = head;
        while (head.next != null){
            temp = head.next;
            head.next = temp.next;
            temp.next = cur;
            cur = temp;
        }
        return cur;
    }
    /**
     * 快慢指针找中心
     * @Function center
     * @author   Oh_MyBug
     * @Date     2020/4/15 1:11
     * @param
     * @return
     */
    public static ListNode center(ListNode head){
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
