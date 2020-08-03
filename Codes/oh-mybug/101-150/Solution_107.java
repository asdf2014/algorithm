import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution_107
 * Date:      2020/4/20 19:57
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。
（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
 */
public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> layers = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        helper(root, layers, 0);
        int len = layers.size();
        for(int i = len - 1; i >= 0; i--){
            res.add(layers.get(i));
        }
        return res;
    }
    /**
     * @Function 树 递归就对了
     * @author   Oh_MyBug
     * @Date     2020/4/20 20:09
     * @param
     * @return
     */
    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if(res.size() == level){
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        if(root.left != null){
            helper(root.left, res, level+1);
        }
        if(root.right != null){
            helper(root.right, res, level+1);
        }
    }
}
