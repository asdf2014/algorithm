/**
 * ClassName: com.ohmybug.Solution_83
 * Date:      2020/4/15 23:08
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
    输入: 1->1->2
    输出: 1->2
示例 2:
    输入: 1->1->2->3->3
    输出: 1->2->3
 */
public class Solution_83 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        ListNode.show(deleteDuplicates(list));
    }
    /**
     * 由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点
     * 进行比较来确定它是否为重复结点。如果它是重复的，我们更改当前结点
     * 的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
     *
     * 复杂度分析
     * 时间复杂度：O(n)，因为列表中的每个结点都检查一次以确定它是否重复，
     * 所以总运行时间为 O(n)，其中 nn 是列表中的结点数。
     * 空间复杂度：O(1)，没有使用额外的空间。
     *
     * @Function deleteDuplicates
     * @author   Oh_MyBug
     * @Date     2020/4/15 23:28
     * @param
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null){
            if (p.val == p.next.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }
}
