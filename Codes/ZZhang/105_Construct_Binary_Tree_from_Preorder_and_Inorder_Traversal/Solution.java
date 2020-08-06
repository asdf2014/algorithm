//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 3575 👎 96


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length,
            inorder, 0, inorder.length, map);
    }

    private TreeNode helper(int[] pre, int pStart, int pEnd, int[] in,
        int iStart, int inEnd, HashMap<Integer, Integer> map) {

        if (pStart == pEnd) return null;

        int rootVal = pre[pStart];
        TreeNode root = new TreeNode(rootVal);

        int i_root_index = map.get(rootVal);
        int leftNum = i_root_index - iStart;

        root.left = helper(pre, pStart + 1, pStart + leftNum + 1, in, iStart, i_root_index, map);
        root.right = helper(pre, pStart + leftNum + 1, pEnd, in, i_root_index + 1, inEnd, map);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
