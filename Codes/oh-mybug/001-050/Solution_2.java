import org.junit.Test;

/**
 * ClassName: com.ohmybug.firstTofifty.Solution_2
 * Date:      2020/4/4 23:47
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是
按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 */
public class Solution_2 {
    @Test
    public void test(){
        ListNode<Integer> list1 = new ListNode(2);
        list1.add(4);
        list1.add(6);
        list1.add(9);
        ListNode<Integer> list2 = new ListNode(5);
        list2.add(6);
        list2.add(4);
        ListNode<Integer> answer = addTwoNumbers(list1, list2);
        System.out.print(answer.val);
        while (answer.next != null){
            answer = answer.next;
            System.out.print(answer.val);
        }
        System.out.println();
    }
    /**
     * 思想：要有进位数plus
     * @Function addTwoNumbers
     * @author   Oh_MyBug
     * @Date     2020/4/5 0:13
     * @param
     * @return
     */
    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode<Integer> answer = new ListNode((l1.val + l2.val)%10);
        int plus = (l1.val + l2.val) - 9 <= 0 ? 0 : 1;
        ListNode<Integer> p = answer;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            p.next = new ListNode((l1.val + l2.val + plus)%10);
            p = p.next;
            plus = (l1.val + l2.val + plus) - 9 <= 0 ? 0 : 1;
        }
        while(l1.next != null){
            l1 = l1.next;
            p.next = new ListNode((l1.val + plus)%10);
            p = p.next;
            plus = (l1.val + plus) - 9 <= 0 ? 0 : 1;
        }
        while(l2.next != null){
            l2 = l2.next;
            p.next = new ListNode((l2.val + plus)%10);
            p = p.next;
            plus = (l2.val + plus) - 9 <= 0 ? 0 : 1;
        }
        if(plus != 0){
            p.next = new ListNode(plus);
        }
        return answer;
    }
}
