/**
 * ClassName: com.ohmybug.firstTofifty.Solution_23
 * Date:      2020/4/15 1:33
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:
    输入:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    输出: 1->1->2->3->4->4->5->6
 */
public class Solution_23 {
//    public static com.ohmybug.fifty_3.ListNode mergeKLists(com.ohmybug.fifty_3.ListNode[] lists) {
//        if (lists.length == 0) return null;
//        com.ohmybug.fifty_3.ListNode temp = lists[0];
//        for (int i = 1; i < lists.length; i ++){
//            temp = mergeTwoLists(temp, lists[i]);
//        }
//        return temp;
//    }
    /**
     * 思想：如果使用遍历的话，就会使得temp链表的数据量一直增大，导致temp和list[i]的
     *       数据量差异也越来越大，这其实隐形的增加了时间复杂度。如果使用归并思想，就可以
     *       使得最后的l1和l2的数据量差异大幅减小，甚至均匀，从而降低了时间复杂度
     * @Function mergeKLists
     * @author   Oh_MyBug
     * @Date     2020/4/15 2:09
     * @param
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    private ListNode merge(ListNode[] lists, int low, int high)
    {
        if(low > high)
            return null;
        if(low == high)
            return lists[low];

        int mid=(low + high)/2;
        ListNode l1 = merge(lists,low,mid);
        ListNode l2 = merge(lists,mid+1,high);
        return mergeTwoLists(l1,l2);
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
