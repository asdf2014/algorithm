/**
 * ClassName: com.ohmybug.Solution_86
 * Date:      2020/4/14 18:11
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
86. 分隔链表

给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例:
    输入: head = 1->4->3->2->5->2, x = 3
    输出: 1->2->2->4->3->5
 */
public class Solution_86 {
    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);
        list = partition(list, 3);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    /**
     * 思想：分隔链表是把链表分割成小区域（比x小）和大区域（比x大或者等于x），
     *       而且要注意保持初始相对位置。我们要做的是遍历链表，然后将值比x小的
     *       结点“摘下”，插入到当前已分好的小区域的最后一个结点。
     *  ① 给head链表加一个“不带值”的头节点（不带值的意思其实是这个值没用），
     *     如果没有这个，会很麻烦，不信可以试试哈哈
     *  ② 设置两个游标cur1和cur2，cur1的作用是指向当前小区域的最后一个结点，
     *     cur2的作用是顺序遍历指向每一个结点
     *  ③ 初始阶段cur1和cur2都指向不带值”的头节点，然后游标cur2开始遍历，
     *     每次判断的是游标cur2的下一个结点，当碰到cur2.next的值比x小的结点时，
     *     就把该结点“摘下”，然后放在当前cur1的后面，最后再让cur1后移；
     *     如果碰到cur2.next的值比x大或相等的结点时，直接让cur2继续后移。
     *
     *     注意：如果刚开始就遇到cur2.next的值比x小的结点的情况时，最后cur2
     *     也要和cur1一样后移，如果cur2没有后移，你可以尝试一下。
     * @Function partition
     * @author   Oh_MyBug
     * @Date     2020/4/14 20:23
     * @param
     * @return
     */
    public static ListNode<Integer> partition(ListNode<Integer> head, int x) {
        if (head == null) return null;
        ListNode<Integer> newList = new ListNode(0);
        newList.next = head;
        ListNode<Integer> cur1 = newList;
        ListNode<Integer> cur2 = newList;
        ListNode<Integer> temp;
        while (cur2.next != null) {
            if ((int)cur2.next.val < x) {
                temp = cur2.next;
                cur2.next = temp.next;
                temp.next = cur1.next;
                cur1.next = temp;
                if (cur1 == cur2){
                    cur2 = cur2.next;
                }
                cur1 = cur1.next;
            } else {
                cur2 = cur2.next;
            }
        }
        return newList.next;
    }
}
