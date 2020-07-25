//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search 
// 👍 4011 👎 538


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
//        return recure(root, null, null);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;
        if (!inorder(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return inorder(root.right);
    }

//    private boolean inorder(TreeNode root) {
//    }

    private boolean recure(TreeNode root, Integer left, Integer right) {
        if (root == null) return true;
        int cur_val = root.val;
        if (left != null && left >= cur_val) return false;
        if (right != null && right <= cur_val) return false;

        if (! recure(root.right, cur_val, right)) return false;
        if (! recure(root.left, left, cur_val)) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
