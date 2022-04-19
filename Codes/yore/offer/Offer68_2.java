package com.yore.offer;

import com.yore.base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/7 7:50
 * @description
 */
public class Offer68_2 {
    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return q;
    }


    /**
     * l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
     * l、r 任一为空，说明 LCA 位于另一子树或其祖先中
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }
}
