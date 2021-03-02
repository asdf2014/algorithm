import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_113
 * Data:        2020/8/5
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        helper(root, sum, root.val, temp, res);
        return res;
    }

    public void helper(TreeNode root, int sum, int sum_temp, List<Integer> temp, List<List<Integer>> res){
        if (root.left == null && root.right == null){
            if (sum == sum_temp)
                res.add(new ArrayList<>(temp));
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            helper(root.left, sum, sum_temp + root.left.val, temp, res);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            helper(root.right, sum, sum_temp + root.right.val, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
