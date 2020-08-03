/**
 * ClassName: com.ohmybug.Solution_61
 * Date:      2020/4/5 0:34
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:
    输入: 0->1->2->NULL, k = 4
    输出: 2->0->1->NULL
解释:
    向右旋转 1 步: 2->0->1->NULL
    向右旋转 2 步: 1->2->0->NULL
    向右旋转 3 步: 0->1->2->NULL
    向右旋转 4 步: 2->0->1->NULL
 */
public class Solution_61 {
    /**
     * 先遍历求得链表总长度length，同时将链表首尾相连；
     * 再找到原链表的倒数第k+1个节点，该节点的next就是新链表的头结点。
     * @Function rotateRight
     * @author   Oh_MyBug
     * @Date     2020/4/5 0:56
     * @param
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = 1;
        ListNode p = head;
        while(p.next != null){
            p = p.next;
            length ++;
        }
        p.next = head;
        p = p.next;
        int temp = length - k % length - 1;
        while(temp-- != 0){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
