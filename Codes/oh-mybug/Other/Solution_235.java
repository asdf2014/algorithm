/**
 * ClassName: Solution_235
 * Date:      2020/4/20 18:52
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
235. 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能
大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
示例 1:
    输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    输出: 6
    解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:
    输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    输出: 2
    解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

说明:
    所有节点的值都是唯一的。
    p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Solution_235 {

    /**
     * @Function 树递归 二叉搜索树性质
     * @author   Oh_MyBug
     * @Date     2020/4/20 19:50
     * @param
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
    public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if((root.val - p.val)*(root.val - q.val) <= 0) return root;
        if (root.val > p.val && root.val > q.val){
            return helper(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val){
            return helper(root.right, p, q);
        }
        return null;
    }
}
