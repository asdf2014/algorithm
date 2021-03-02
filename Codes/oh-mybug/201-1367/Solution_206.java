import org.junit.Test;

/**
 * ClassName: Solution_206
 * Date:      2020/4/4 15:24
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
206. 反转链表

示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL

进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution_206 {
    @Test
    public void test(){
        ListNode list = new ListNode(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        show(list);
        ListNode reverseList = reverseList(list);
        show(reverseList);
    }
    /**
     * 核心函数，反转链表
     * 思想：
     *  举例说明：
     *      输入链表List：1->2->3->4->5->NULL
     *      新建头节点为0的新链表，即 newList: 0->NULL（0节点作为头节点）
     *      将原链表List的头部接到newList上：0->1->2->3->4->5->NULL
     *      将list的第一个结点当作一个游标cur(即为原链表的head结点)，当前cur所在位置为val=1的位置
     *      进入循环：如果cur的下一个结点不为空：
     *          ① 将cur的下一个结点赋给临时变量temp，此时：
     *              list = 1->2->3->4->5->NULL
     *              temp = 2->3->4->5->NULL
     *              newList = 0->1->2->3->4->5->NULL
     *          ② 删除游标cur的下一个结点：将cur的下一个结点改为cur的下下个结点，即：head.next = temp.next; 此时：
     *              list = 1->3->4->5->NULL
     *              temp = 2->3->4->5->NULL
     *              newList = 0->1->3->4->5->NULL
     *          ③ 临时结点temp独立：删除temp结点之后的所有结点，即：temp.next = null； 此时：
     *              list = 1->3->4->5->NULL
     *              temp = 2->NULL
     *              newList = 0->1->3->4->5->NULL
     *          ④ 将临时结点temp插入新链表头部与新链表头部下一个结点，即：
     *              1. temp.next = newList.next;
     *              2. newList.next = temp; 此时：
     *                  list = 1->3->4->5->NULL
     *                  temp = 2->NULL
     *                  newList = 0->2->1->3->4->5->NULL
     *          ⑤ 继续循环直至结束
     *       返回newList
     * @Function reverseList
     * @author   Oh_MyBug
     * @Date     2020/4/4 16:57
     * @param
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode newlist = new ListNode(0);
        newlist.next = head;
        head = newlist.next;
        while(head.next != null){
            temp = head.next;
            head.next = temp.next;
            temp.next = newlist.next;
            newlist.next = temp;
        }
        return newlist.next;
    }
    /**
     * 顺序打印链表的所有节点值
     * @Function show
     * @author   Oh_MyBug
     * @Date     2020/4/4 16:57
     * @param    
     * @return   
     */
    public static void show(ListNode head){
        while (head.next != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

