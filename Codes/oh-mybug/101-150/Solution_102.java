import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution_102
 * Date:      2020/4/18 23:11
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
    二叉树：[3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
返回其层次遍历结果：

    [
      [3],
      [9,20],
      [15,7]
    ]
 */
public class Solution_102 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if (result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null){
            helper(root.left, level + 1);
        }
        if (root.right != null){
            helper(root.right, level + 1);
        }
    }
}
