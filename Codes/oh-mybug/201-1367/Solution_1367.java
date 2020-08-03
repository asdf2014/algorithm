import org.junit.Test;

/*
给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。

示例 1：
输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true
解释：树中蓝色的节点构成了与链表对应的子路径。

示例 2：
输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：true

示例 3：

输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
输出：false
解释：二叉树中不存在一一对应链表的路径。
 */
public class Solution_1367 {
    @Test
    public void test(){
        Integer[] values = new Integer[]{1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};
        Tree tree = new Tree();
        tree.generateTree(values);
        tree.PreOrder(tree.getRoot());
    }

    public static boolean isSubPath(ListNode<Integer> head, TreeNode root) {
        if (root == null) return false;
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static boolean helper(ListNode<Integer> head, TreeNode root){
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}
