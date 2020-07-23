//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree 
// 👍 3204 👎 135


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class ColorNode {
    public int color;
    public TreeNode node;
    public ColorNode(int col, TreeNode node) {
        this.color = col;
        this.node = node;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         return recure(root);
//        return stack(root);
    }

    private List<Integer> stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        int white = 0;
        int grew = 1;
        stack.push(new ColorNode(white, root));

        while (! stack.isEmpty()) {
            ColorNode cnode = stack.pop();
            if (cnode.node == null) continue;

            if (cnode.color == white) {
                stack.push(new ColorNode(white, cnode.node.right));
                stack.push(new ColorNode(grew, cnode.node));
                stack.push(new ColorNode(white, cnode.node.left));
            } else {
                res.add(cnode.node.val);
            }
        }
        return res;
    }

    private List<Integer> recure(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
