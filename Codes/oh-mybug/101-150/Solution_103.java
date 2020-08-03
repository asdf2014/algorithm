import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:   Solution_103
 * Data:        2020/8/2
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution_103 {
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        TreeNode node = null;

        queue.add(root);
        while (true) {
            if (queue.size() == 0) break;
            while (queue.size() != 0) {
                node = queue.remove(0);
                temp.add(node.val);
                if (node.left != null)
                    stack.add(node.left);
                if (node.right != null)
                    stack.add(node.right);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();

            if (stack.size() == 0) break;
            while (stack.size() != 0) {
                node = stack.remove(stack.size() - 1);
                temp.add(node.val);
                if (node.right != null)
                    queue.add(0, node.right);
                if (node.left != null)
                    queue.add(0, node.left);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
    }*/

    // DFS
    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }
}
