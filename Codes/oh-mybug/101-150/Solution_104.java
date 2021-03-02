/**
 * ClassName: Solution_104
 * Date:      2020/4/18 23:52
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
    给定二叉树 [3,9,20,null,null,15,7]，

        3
       / \
      9  20
        /  \
       15   7
    返回它的最大深度 3 。

 */
public class Solution_104 {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return depth;
        helper(root, 1);
        return depth;
    }
    /**
     * 递归 套路
     * @Function helper
     * @author   Oh_MyBug
     * @Date     2020/4/18 23:53
     * @param
     * @return
     */
    public void helper(TreeNode root, int sum){
        if(depth < sum) depth = sum;
        if (root.left != null){
            helper(root.left, sum + 1);
        }
        if (root.right != null){
            helper(root.right, sum + 1);
        }
    }
}
