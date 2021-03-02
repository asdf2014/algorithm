//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 1449 👎 692


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
    public int minDepth(TreeNode root) {
        return recur(root);
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;

        if (root.left != null) min_depth = Math.min(recur(root.left), min_depth);
        if (root.right != null) min_depth = Math.min(recur(root.right), min_depth);

        return min_depth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
