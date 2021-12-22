//给定一个链表，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 1099 👎 0

import java.util.ArrayList;
import java.util.List;

//package leetcode.editor.cn;
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = l2;
        ListNode l3 = new ListNode(1);
        System.out.println(solution.hasCycle(l1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head==null){
                return false;
            }
            List<Integer> memo=new ArrayList<>();
            while (head.next != null) {
                if (!memo.contains(head.hashCode())){
                    memo.add(head.hashCode());
                    head=head.next;
                }else {
                    return true;
                }
            }
            return false;
        }
//        public boolean hasCycle(ListNode head) {
//            ListNode slow=head,fast=head;
//            while (fast!=null&&fast.next!=null){
//                slow=slow.next;
//                fast=fast.next.next;
//                if (slow==fast){
//                    return true;
//                }
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}