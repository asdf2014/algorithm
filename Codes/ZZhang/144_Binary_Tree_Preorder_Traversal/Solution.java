//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree 
// 👍 1556 👎 58


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
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

class ColorsNode {
    int color;
    TreeNode node;
    ColorsNode(int c, TreeNode n){
        this.color = c;
        this.node = n;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return recure(root);
//        return iter(root);
    }

    private List<Integer> iter(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<ColorsNode> stack = new Stack<>();
        int white = 0;
        int grey = 1;
        stack.push(new ColorsNode(white, root));

        while(! stack.isEmpty()) {
            ColorsNode colorNode = stack.pop();
            if (colorNode.node == null) continue;
            if (colorNode.color == white) {
                stack.push(new ColorsNode(white, colorNode.node.right));
                stack.push(new ColorsNode(white, colorNode.node.left));
                stack.push(new ColorsNode(grey, colorNode.node));
            } else {
                res.add(colorNode.node.val);
            }
        }
        return res;
    }

    private List<Integer> recure(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
