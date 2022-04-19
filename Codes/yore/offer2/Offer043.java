package com.yore.offer2;

import com.yore.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 11:02
 * @description
 */
public class Offer043 {
    class CBTInserter {
        TreeNode node;
        Deque<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.queue = new LinkedList<>();
            this.node = root;
            process(node);
        }

        public void process(TreeNode node) {
            TreeNode t = node;
            queue.offerLast(t);
            while (true) {
                t = queue.peekFirst();
                if (t.left != null) {
                    queue.offerLast(t.left);
                }
                if (t.right != null) {
                    queue.offerLast(t.right);
                }
                if (t.left != null && t.right != null) {
                    queue.pollFirst();
                } else {
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            TreeNode parent = queue.peekFirst();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
                queue.pollFirst();
            }
            queue.offerLast(node);
            return parent.val;
        }

        public TreeNode get_root() {
            return this.node;
        }
    }
}
