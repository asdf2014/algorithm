/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //这道题直接模拟加法运算来做就行
        //首先声明一个listNode用于存储结果
        ListNode ans=new ListNode(-1);
        ListNode idx=ans;

        //设置两个指针，分别指向两个数字
        ListNode idx1=l1;
        ListNode idx2=l2;

        //设置一个数字，看是否进位
        int jin=0;

        while(idx1!=null&&idx2!=null){
            //保存当前的值
            ListNode cur=new ListNode((idx1.val+idx2.val+jin)%10);
            idx.next=cur;
            idx=idx.next;
            jin=(idx1.val+idx2.val+jin)/10;
            idx1=idx1.next;
            idx2=idx2.next;
        }

        //如果第一个链表没有遍历完，继续遍历
        while(idx1!=null){
            ListNode cur=new ListNode((idx1.val+jin)%10);
            idx.next=cur;
            idx=idx.next;
            jin=(idx1.val+jin)/10;
            idx1=idx1.next;
        }

        //如果第二个链表没有遍历完，继续遍历
        while(idx2!=null){
            ListNode cur=new ListNode((idx2.val+jin)%10);
            idx.next=cur;
            idx=idx.next;
            jin=(idx2.val+jin)/10;
            idx2=idx2.next;
        }

        //如果最后进位不为0，就在加上进的这一位
        if(jin!=0) idx.next=new ListNode(jin);

        return ans.next;
    }
}