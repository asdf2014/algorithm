/**
 * ClassName: com.ohmybug.firstTofifty.Solution_19
 * Date:      2020/4/14 21:56
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：
    给定的 n 保证是有效的。
进阶：
    你能尝试使用一趟扫描实现吗？
 */
public class Solution_19 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
        list = removeNthFromEnd(list, 1);

        while (list.next != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println(list.val + " ");
    }

    /**
     * 核心思想：如何一趟扫描完成？
     * 其实如果按实际的遍历一趟扫描是不可能完成的，但是知道了快慢指针的思想，或许可以
     * 转换思路：以前算长度都是length++一个一个数，其实在实际生活中数数的时候我们为了
     * 更快的数数，会两个两个数，甚至多个多个...所以在本题中，我两个两个数，数出长度length，
     * 由长度length再计算出要删除第几个结点，最后再两个两个数过去找那个结点。
     * @Function removeNthFromEnd
     * @author   Oh_MyBug
     * @Date     2020/4/14 22:25
     * @param
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int length = 1;
        while (true) {
            if (p.next == null) break;
            if (p.next.next != null) {
                p = p.next.next;
                length += 2;
            } else {
                length++;
                break;
            }
        }
        if (length == n) {
            return head.next;
        }
        int count = (length - n - 1) / 2;
        p = head;
        while (count != 0) {
            p = p.next.next;
            count--;
        }
        if ((length - n - 1) % 2 == 1)
            p = p.next;
        p.next = p.next.next;
        return head;
    }
}
